package com.brunocastagna.carrito_service_electro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precioUnitario;
}
