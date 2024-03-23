package com.coderhouse.desafioclienterest.modell;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "dni")
    private int dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private Date fechaNAciomiento;

    //Constructor con parametros

    public Cliente(int dni, String nombre, String apellido, Date fechaNAciomiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNAciomiento = fechaNAciomiento;
    }

    //Constructor vacio para la persistencia
    public Cliente() {

    }

    //Getters y Setters


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNAciomiento() {
        return fechaNAciomiento;
    }

    public void setFechaNAciomiento(Date fechaNAciomiento) {
        this.fechaNAciomiento = fechaNAciomiento;
    }
}
