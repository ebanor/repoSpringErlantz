package com.mikeldi.demo.component;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.mikeldi.demo.model.UsuarioRol;

@Component("usuariosRolesComponent")
public class UsuariosRolesComponent {
    
    public ArrayList<UsuarioRol> obtenerUsuariosRoles() {
        ArrayList<UsuarioRol> usuariosRoles = new ArrayList<>();
        
        usuariosRoles.add(new UsuarioRol(1, 1, 1));
        usuariosRoles.add(new UsuarioRol(2, 2, 2));
        usuariosRoles.add(new UsuarioRol(3, 3, 3));
        
        return usuariosRoles;
    }
    
    public ArrayList<Integer> obtenerRolesDeUsuario(int usuarioId) {
        ArrayList<UsuarioRol> todas = obtenerUsuariosRoles();
        ArrayList<Integer> rolesIds = new ArrayList<>();
        
        for (UsuarioRol ur : todas) {
            if (ur.getUsuarioId() == usuarioId) {
                rolesIds.add(ur.getRolId());
            }
        }
        
        return rolesIds;
    }
    
    public ArrayList<Integer> obtenerUsuariosConRol(int rolId) {
        ArrayList<UsuarioRol> todas = obtenerUsuariosRoles();
        ArrayList<Integer> usuariosIds = new ArrayList<>();
        
        for (UsuarioRol ur : todas) {
            if (ur.getRolId() == rolId) {
                usuariosIds.add(ur.getUsuarioId());
            }
        }
        
        return usuariosIds;
    }
}