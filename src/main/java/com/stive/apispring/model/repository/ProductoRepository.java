package com.stive.apispring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stive.apispring.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
