package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.model.Producto;
import com.example.service.ProductoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoApiController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoServicio.listarTodosLosProductos();
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoServicio.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto modificarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoServicio.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoServicio.borrarProducto(id);
    }
}
