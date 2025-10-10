package com.mikeldi.demo.model;

import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private java.time.LocalDateTime fechaDeAlta;
    private boolean estado;
    private java.time.LocalDateTime ultimoInicio;
    private Rol rol;

    public Usuario() {}

    public Usuario(int id, String nombre, String correo, String contraseña, LocalDateTime fechaDeAlta, boolean estado, LocalDateTime ultimoInicio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaDeAlta = fechaDeAlta;
        this.estado = estado;
        this.ultimoInicio = ultimoInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public java.time.LocalDateTime getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(java.time.LocalDateTime fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public java.time.LocalDateTime getUltimoInicio() {
        return ultimoInicio;
    }

    public void setUltimoInicio(java.time.LocalDateTime ultimoInicio) {
        this.ultimoInicio = ultimoInicio;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}