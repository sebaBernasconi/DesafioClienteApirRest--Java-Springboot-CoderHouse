package com.coderhouse.desafioclienterest.repository;

import com.coderhouse.desafioclienterest.modell.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
