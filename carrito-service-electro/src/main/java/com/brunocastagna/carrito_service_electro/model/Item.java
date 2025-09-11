package com.brunocastagna.carrito_service_electro.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    private Long idProducto;
    private int cantidad;
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "idCarrito")
    @JsonIgnore
    private Carrito unCarrito;



}
