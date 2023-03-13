package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo); // para insertar o modificar(Si viene el idCliente o no)

    public void delete(Articulo articulo);
}