package com.cibertec.cibertec.service;

import java.util.List;
import java.util.Optional;


import com.cibertec.cibertec.entity.Producto;

public interface ProductoService {
 public abstract List<Producto> listaProducto();
 
  public abstract Producto insertaActualizaProducto(Producto obj);    
    public abstract void eliminaProducto(int id);
    public abstract Optional<Producto>obtenerId(int id);
}
