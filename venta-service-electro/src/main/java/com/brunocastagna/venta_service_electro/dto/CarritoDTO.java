package com.brunocastagna.venta_service_electro.dto;


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
    private List<ProductoDTO> listaProducto;
    private BigDecimal total;
}
