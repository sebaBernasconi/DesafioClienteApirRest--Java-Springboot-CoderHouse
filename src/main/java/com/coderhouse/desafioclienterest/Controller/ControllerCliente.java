package com.coderhouse.desafioclienterest.Controller;

import com.coderhouse.desafioclienterest.modell.Cliente;
import com.coderhouse.desafioclienterest.repository.ClienteRepository;
import com.coderhouse.desafioclienterest.service.ClienteService;
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
    ClienteService clienteService;

    //Listando todos los clientes
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>>listarTodosLosAlumnos(){
        try {
            List<Cliente> todosLosClientes = clienteService.listarTodos();
            return new ResponseEntity<>(todosLosClientes,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Buscando un cliente por dni
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente>buscarPorDni(@PathVariable("id") int dni){
        try {
            Cliente cliente = clienteService.buscarPorDni(dni);
            if (cliente != null){
                return new ResponseEntity<>(cliente,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(cliente,HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Agregando un cliente a la bd
    @PostMapping(value = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente>agregarCliente(@RequestBody Cliente cliente){
            clienteService.agregarCliente(cliente);
            return new ResponseEntity<>(cliente,HttpStatus.CREATED);
    }

    //Editando un cliente
    @PutMapping(value = "/modificar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente>modificarPorDni(@PathVariable("id") int dni,
                                                  @RequestBody Cliente cliente){
            Cliente clienteEditado = clienteService.editarClientePorDni(dni,cliente);
            if (clienteEditado != null){
                return new ResponseEntity<>(clienteEditado,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }

    //Borrando un cliente
    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<Void>borrarPorDni(@PathVariable("id") int dni){
        boolean eliminado = clienteService.eliminarPorDni(dni);
        if (eliminado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
