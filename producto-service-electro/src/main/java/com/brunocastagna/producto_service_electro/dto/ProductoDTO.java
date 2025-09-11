package com.brunocastagna.producto_service_electro.dto;

import com.brunocastagna.producto_service_electro.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precioUnitario;

    public ProductoDTO(Producto p) {
        this.id = p.getIdProducto();
        this.nombre = p.getNombre();
        this.precioUnitario = p.getPrecioUnitario();
    }
}
