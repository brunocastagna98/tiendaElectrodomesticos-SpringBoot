package com.brunocastagna.producto_service_electro.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Table(name = "productos")
@AllArgsConstructor
@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    //Le digo a la columna que NO puede quedar vacia y..
    //NO puede tener codigos repetidos
    @Column(nullable = false, unique = true)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private BigDecimal precioUnitario;

}
