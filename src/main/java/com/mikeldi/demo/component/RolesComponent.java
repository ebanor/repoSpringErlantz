package com.mikeldi.demo.component;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.mikeldi.demo.model.Rol;

@Component("rolesComponent")
public class RolesComponent {
    
    public ArrayList<Rol> obtenerRoles() {
        ArrayList<Rol> roles = new ArrayList<>();
        Rol admin = new Rol(1L, "Administrador");
        admin.setDescripcionRol("Tiene todos los privilegios.");
        roles.add(admin);

        Rol usuario = new Rol(2L, "Usuario");
        usuario.setDescripcionRol("Puede acceder a funciones básicas.");
        roles.add(usuario);

        Rol moderador = new Rol(3L, "Moderador");
        moderador.setDescripcionRol("Puede moderar contenido.");
        roles.add(moderador);

        Rol invitado = new Rol(4L, "Invitado");
        invitado.setDescripcionRol("Tiene acceso limitado.");
        roles.add(invitado);
        return roles;
    }
}
