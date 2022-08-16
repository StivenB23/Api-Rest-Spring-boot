package com.stive.apispring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stive.apispring.model.Producto;
import com.stive.apispring.model.service.ProductoServicie;

@RestController
public class ProductoController {
    @Autowired
    private ProductoServicie servicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return servicio.listarproductos();
    }

    @GetMapping("/productos/{id}")
    public  ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try{
            Producto producto = servicio.obtenerProducto(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        servicio.guardar(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try{
            Producto productoActual = servicio.obtenerProducto(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());

            servicio.guardar(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        servicio.eliminarProducto(id);
    }
}
