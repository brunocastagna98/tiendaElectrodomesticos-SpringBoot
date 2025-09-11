package com.brunocastagna.carrito_service_electro.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "carritos")
public class Carrito {

    // Entonces ...Carrito tiene muchos items y muchos items tiene un solo carrito
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;
    // con cascade y orphanRemoval si borro un carrito se borra todos los items
    @OneToMany(mappedBy = "unCarrito", cascade = CascadeType.ALL, orphanRemoval = true)
    // es mejor los arraylist para evitar el nullpointerexeption
    private List<Item> listaItems = new ArrayList<>();
    private BigDecimal total;





}
