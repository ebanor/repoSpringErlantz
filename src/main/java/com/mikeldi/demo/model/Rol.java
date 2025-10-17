package com.mikeldi.demo.model;

public class Rol {

    private Long id;
    private String nombreRol;
    private String descripcionRol;

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }


    public Rol() {}

    public Rol(Long id, String nombreRol) {
        super();
        this.id = id;
        this.nombreRol = nombreRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
