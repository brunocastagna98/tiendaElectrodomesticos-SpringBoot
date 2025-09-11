package com.brunocastagna.venta_service_electro.model;


import com.brunocastagna.venta_service_electro.dto.CarritoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private LocalDate fechaVenta;
    //Relaciono con carrito
    private Long idCarrito;
    private BigDecimal montoTotal;

}
