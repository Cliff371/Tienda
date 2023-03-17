package com.tienda.dao;

import org.springframework.data.repository.CrudRepository;
import com.tienda.domain.Cliente;
import java.util.List;


public interface ClienteDao extends CrudRepository<Cliente, Object> {
    
    List<Cliente> findByApellidosContainingIgnoreCase(String apellidos);
}
