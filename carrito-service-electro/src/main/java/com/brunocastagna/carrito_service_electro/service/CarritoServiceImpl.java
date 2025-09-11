package com.brunocastagna.carrito_service_electro.service;

import com.brunocastagna.carrito_service_electro.clients.ProductoClient;
import com.brunocastagna.carrito_service_electro.dto.CarritoDTO;
import com.brunocastagna.carrito_service_electro.dto.ItemDTO;
import com.brunocastagna.carrito_service_electro.dto.ProductoDTO;
import com.brunocastagna.carrito_service_electro.model.Carrito;
import com.brunocastagna.carrito_service_electro.model.Item;
import com.brunocastagna.carrito_service_electro.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final ProductoClient productoClient;
    private final CarritoRepository carritoRepo;


    public CarritoServiceImpl(ProductoClient productoClient, CarritoRepository carritoRepo) {
        this.productoClient = productoClient;
        this.carritoRepo = carritoRepo;
    }

    @Override
    public Carrito crearCarrito(Carrito carrito) {
        carrito.setTotal(BigDecimal.ZERO);
        return carritoRepo.save(carrito);

        //con zero me evito el quilombo de null

    }



    @Override
    public void eliminarCarrito(Long idCarrito) {
        carritoRepo.deleteById(idCarrito);
    }



    //Obtener por DTO
    @Override
    public CarritoDTO obtenerCarritoDTO(Long idCarrito) {
        Carrito carrito = carritoRepo.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        List<ItemDTO> productos = new ArrayList<>();
        for (Item item : carrito.getListaItems()) {
            // Traigo datos del producto
            ProductoDTO producto = productoClient.traerProducto(item.getIdProducto());

            // Armo el ItemDTO con la info del producto + cantidad + subtotal
            ItemDTO itemDTO = new ItemDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecioUnitario(),
                    item.getCantidad(),
                    item.getSubTotal()
            );

            productos.add(itemDTO);
        }

        return new CarritoDTO(carrito.getIdCarrito(), carrito.getTotal(), productos);
    }








    @Override
    public Carrito obtenerCarrito(Long idCarrito) {
        return carritoRepo.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    @Override
    public Carrito agregarItem(Long idCarrito, Long idProducto, int cantidad) {
        // 1. Buscar carrito
        Carrito carrito = carritoRepo.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        // 2. Traer producto desde el microservicio de productos
        ProductoDTO producto = productoClient.traerProducto(idProducto);

        // 3. Buscar si el producto ya está en el carrito (con for)
        //con esto determino cuales items estan o no para no repetirlos
        //cuando agrego items del mismo tipo
        // separo los items que ya estan como item, con null cuando no estan
        Item itemExistente = null;
        for (Item item : carrito.getListaItems()) {
            if (item.getIdProducto().equals(idProducto)) {
                itemExistente = item;
                break;
            }
        }

        //Entonces
        // 4. Lógica de agregar
        //Si el item es dintinto a null actualiza la cantidad y el subtotal
        if (itemExistente != null) {
            // Si existe → actualizar cantidad y subtotal
            int nuevaCantidad = itemExistente.getCantidad() + cantidad;
            itemExistente.setCantidad(nuevaCantidad);
            itemExistente.setSubTotal(producto.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(nuevaCantidad)));
        } else {
            // Si no existe → crear un nuevo item
            Item item = new Item();
            item.setIdProducto(idProducto);
            item.setCantidad(cantidad);
            item.setSubTotal(producto.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(cantidad)));
            item.setUnCarrito(carrito);

            carrito.getListaItems().add(item);
        }

        // 5. Recalcular total del carrito
        BigDecimal nuevoTotal = BigDecimal.ZERO;
        for (Item item : carrito.getListaItems()) {
            nuevoTotal = nuevoTotal.add(item.getSubTotal());
        }
        carrito.setTotal(nuevoTotal);

        // 6. Guardar cambios
        return carritoRepo.save(carrito);
    }


    @Override
    public Carrito quitarItem(Long idCarrito, Long idProducto, int cantidad) {
        // 1. Buscar carrito
        Carrito carrito = carritoRepo.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        Item itemExistente = null;

        // 2. Buscar ítem en el carrito
        for (Item item : carrito.getListaItems()) {
            if (item.getIdProducto().equals(idProducto)) {
                itemExistente = item;
                break;
            }
        }

        if (itemExistente == null) {
            throw new RuntimeException("Producto no encontrado en el carrito");
        }

        // 3. Lógica de quitar
        if (cantidad < itemExistente.getCantidad()) {
            int nuevaCantidad = itemExistente.getCantidad() - cantidad;
            itemExistente.setCantidad(nuevaCantidad);

            // Calcular precio unitario
            BigDecimal precioUnitario = itemExistente.getSubTotal()
                    .divide(BigDecimal.valueOf(itemExistente.getCantidad() + cantidad));

            // Recalcular subtotal
            itemExistente.setSubTotal(precioUnitario.multiply(BigDecimal.valueOf(nuevaCantidad)));

        } else {
            carrito.getListaItems().remove(itemExistente);
        }

        // 4. Recalcular total del carrito
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : carrito.getListaItems()) {
            total = total.add(item.getSubTotal());
        }
        carrito.setTotal(total);

        // 5. Guardar cambios
        return carritoRepo.save(carrito);
    }




}
