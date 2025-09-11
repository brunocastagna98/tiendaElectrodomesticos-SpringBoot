package com.brunocastagna.venta_service_electro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    @JsonProperty("idProducto")
    private Long id;
    private String nombre;
    private BigDecimal precioUnitario;
    private int cantidad;
    private BigDecimal subTotal;
}
