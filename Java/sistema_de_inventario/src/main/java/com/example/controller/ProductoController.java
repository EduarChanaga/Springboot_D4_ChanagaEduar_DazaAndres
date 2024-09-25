package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.model.Producto;
import com.example.service.ProductoServicio;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoServicio.listarTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos"; // nombre de la vista
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "nuevo-producto"; // vista para agregar un nuevo producto
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoServicio.crearProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}")
    public String obtenerProductoPorId(@PathVariable Long id, Model model) {
        Producto producto = productoServicio.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "editar-producto"; // vista para editar el producto
    }

    @PostMapping("/{id}")
    public String modificarProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
        productoServicio.actualizarProducto(id, producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(@PathVariable Long id) {
        productoServicio.borrarProducto(id);
        return "redirect:/productos";
    }
}
