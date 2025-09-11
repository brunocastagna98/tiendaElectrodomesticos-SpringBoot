package com.brunocastagna.producto_service_electro.repository;

import com.brunocastagna.producto_service_electro.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
