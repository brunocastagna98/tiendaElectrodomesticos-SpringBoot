package com.brunocastagna.venta_service_electro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    private Long idVenta;
    private LocalDate fechaVenta;
    private BigDecimal montoTotal;
    private Long idCarrito;

    private List<ProductoDTO> listaProductos;

}
