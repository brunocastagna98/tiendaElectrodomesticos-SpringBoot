package com.brunocastagna.carrito_service_electro.repository;

import com.brunocastagna.carrito_service_electro.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Long> {
}
