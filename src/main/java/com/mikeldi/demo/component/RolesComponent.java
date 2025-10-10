package com.mikeldi.demo.component;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.mikeldi.demo.model.Rol;

@Component("rolesComponent")
public class RolesComponent {
    
    public ArrayList<Rol> obtenerRoles() {
        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(new Rol(1, "Administrador"));
        roles.add(new Rol(2, "Usuario"));
        roles.add(new Rol(3, "Moderador"));
        roles.add(new Rol(4, "Invitado"));
        return roles;
    }
}