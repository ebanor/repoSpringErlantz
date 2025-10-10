package com.mikeldi.demo.model;

public class UsuarioRol {
    private int id;
    private int usuarioId;
    private int rolId;
    
    public UsuarioRol() {}
    
    public UsuarioRol(int id, int usuarioId, int rolId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.rolId = rolId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public int getRolId() {
        return rolId;
    }
    
    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}