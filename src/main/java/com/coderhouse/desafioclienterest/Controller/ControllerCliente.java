package com.coderhouse.desafioclienterest.Controller;

import com.coderhouse.desafioclienterest.modell.Cliente;
import com.coderhouse.desafioclienterest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Cliente>> buscarTodos(){
        try {
            List<Cliente> todosLosClientes = clienteRepository.findAll();
            return new ResponseEntity<>(todosLosClientes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> buscarClientePorDni(@PathVariable("id") int dni){
        try {
            Cliente cliente = clienteRepository.findById(dni).orElse(null);
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/agregarCliente", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return new ResponseEntity<>(cliente,HttpStatus.CREATED);
    }
}
