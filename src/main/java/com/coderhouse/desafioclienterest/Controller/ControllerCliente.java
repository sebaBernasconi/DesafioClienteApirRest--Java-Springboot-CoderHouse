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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    //Listando todos los clientes

}
