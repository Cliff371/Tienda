package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service    //Importante para que levante todos los metedos y tiene que ir en el lugar especifico
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);

        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }

    @Override
    public List<Cliente> getClientePorNombre(String nombre) {
        return clienteDao.findByNombre(nombre);
    }

    @Override
    public List<Cliente> getClientePorTelefono(String telefono) {
        return clienteDao.findByTelefono(telefono);
    }

    @Override
    public List<Cliente> findByNombreOrApellidosPrTelefono(String nombre, String apellidos, String telefono) {
        return clienteDao.findByNombreOrApellidosOrTelefono(nombre, apellidos, telefono);   }
}