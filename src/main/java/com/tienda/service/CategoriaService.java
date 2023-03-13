package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); // para insertar o modificar(Si viene el idCliente o no)
    
    public void delete(Categoria categoria);
    
}
