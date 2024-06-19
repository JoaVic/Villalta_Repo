package com.cibertec.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cibertec.entity.Producto;
import com.cibertec.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

 @Autowired
    private ProductoRepository repoProd;

    @Override
    public List<Producto> listaProducto() {
        return repoProd.findAll();
    }

    @Override
    public Producto insertaActualizaProducto(Producto obj) {
       return repoProd.save(obj);
    }

    @Override
    public void eliminaProducto(int id) {
        repoProd.deleteById(id);
    }

    @Override
    public Optional<Producto> obtenerId(int id) {
        return repoProd.findById(id);
    }
    
}
