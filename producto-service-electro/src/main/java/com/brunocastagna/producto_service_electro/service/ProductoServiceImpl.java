package com.brunocastagna.producto_service_electro.service;

import com.brunocastagna.producto_service_electro.model.Producto;
import com.brunocastagna.producto_service_electro.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{


    //Inyecto por constructor al repository

    private final ProductoRepository produRepo;

    public ProductoServiceImpl(ProductoRepository produRepo) {
        this.produRepo = produRepo;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return produRepo.save(producto);
    }

    @Override
    public Producto traerProducto(Long idProducto) {
        return produRepo.findById(idProducto).orElse(null);
    }

    @Override
    public List<Producto> traerTodos() {
        return produRepo.findAll();
    }

    @Override
    public Producto editarProducto(Long idProducto, Producto produEditado) {

        //Traigo el producto
        Producto productoExistente = produRepo.findById(idProducto).orElse(null);
        if(productoExistente != null ){
            //Seteo lo que existe con el Get del edit
            productoExistente.setCodigoProducto(produEditado.getCodigoProducto());
            productoExistente.setNombre(produEditado.getNombre());
            productoExistente.setMarca(produEditado.getMarca());
            productoExistente.setPrecioUnitario(produEditado.getPrecioUnitario());
            //Retorno los cambios
            return produRepo.save(productoExistente);
        }
        return null; //Si no lo encuentra es null
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        produRepo.deleteById(idProducto);
    }
}
