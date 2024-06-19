package com.cibertec.cibertec.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.cibertec.entity.Producto;
import com.cibertec.cibertec.service.ProductoService;

@RestController
@RequestMapping("/url/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoservice;

     @GetMapping("/listaTodos")
    public List<Producto> getAllClientes() {
        return productoservice.listaProducto();
    
    }

    @PostMapping("/registrarProducto")
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
               HashMap<String, Object> salida = new HashMap<>();
            try {
                producto.setIdproducto(0);
                Producto objSalida = productoservice.insertaActualizaProducto(producto);
            salida.put("mensaje", "Producto registrado de ID >>> " + objSalida.getIdproducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto objSalida = productoservice.insertaActualizaProducto(producto);
            salida.put("mensaje", "Producto actualizado de ID >>> " + objSalida.getIdproducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productoservice.eliminaProducto(id);
            salida.put("mensaje", "Producto eliminado de ID >>> " + id);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto producto = productoservice.obtenerId(id).get();
            salida.put("Producto", producto);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }
}
