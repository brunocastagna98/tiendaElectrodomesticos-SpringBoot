package com.brunocastagna.carrito_service_electro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarritoDTO {
    private Long idCarrito;
    private BigDecimal total;
    private List<ItemDTO> listaProducto;
}