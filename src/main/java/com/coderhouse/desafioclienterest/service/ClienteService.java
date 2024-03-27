package com.coderhouse.desafioclienterest.service;

import com.coderhouse.desafioclienterest.modell.Cliente;
import com.coderhouse.desafioclienterest.repository.ClienteRepository;
import jakarta.websocket.ClientEndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente>listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorDni(int dni){
        return clienteRepository.findById(dni).orElse(null);
    }

    public Cliente agregarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente editarClientePorDni(int dni, Cliente cliente,
                                       String nuevoNombre, String nuevoApellido){
        try {
            if (clienteRepository.existsById(dni)){
                cliente.setNombre(nuevoNombre);
                cliente.setApellido(nuevoApellido);
                return clienteRepository.save(cliente);
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    public boolean eliminarPorDni(int dni){
        try {
            clienteRepository.deleteById(dni);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
