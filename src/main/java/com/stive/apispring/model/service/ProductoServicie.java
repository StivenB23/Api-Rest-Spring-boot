package com.stive.apispring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stive.apispring.model.Producto;
import com.stive.apispring.model.repository.ProductoRepository;

@Service
public class ProductoServicie {
    @Autowired
    private ProductoRepository productorepository;

    public List<Producto> listarproductos(){
        return productorepository.findAll();
    }
    public void guardar(Producto producto){
        productorepository.save(producto);
    }
    public Producto obtenerProducto(Integer id){
        return productorepository.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        productorepository.deleteById(id);
    }
}
