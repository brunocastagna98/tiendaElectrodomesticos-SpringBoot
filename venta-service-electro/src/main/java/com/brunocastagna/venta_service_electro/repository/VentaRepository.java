package com.brunocastagna.venta_service_electro.repository;

import com.brunocastagna.venta_service_electro.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {
}
