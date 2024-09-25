package com.example.service;

import com.example.model.Producto;
import com.example.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listarTodosLosProductos() {
        try {
            return productoRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los productos", e);
        }
    }

    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoDetails) {
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setCantidad(productoDetails.getCantidad());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setCategoria(productoDetails.getCategoria());
        return productoRepositorio.save(producto);
    }

    public void borrarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
