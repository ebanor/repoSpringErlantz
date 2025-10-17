package com.mikeldi.demo.component;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mikeldi.demo.model.Rol;
import com.mikeldi.demo.model.Usuario;

@Component("usuariosComponent")
public class UsuariosComponent {
    
    @Autowired
    @Qualifier("rolesComponent")
    RolesComponent rolesComponent;
    
    @Autowired
    @Qualifier("usuariosRolesComponent")
    UsuariosRolesComponent usuariosRolesComponent;
    
    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setDni("12345678A");
        usuario1.setNombre("Juan Pérez");
        usuario1.setCorreo("juan@example.com");
        usuario1.setContraseña("pass123");
        usuario1.setFechaDeAlta(LocalDateTime.now().minusDays(30));
        usuario1.setEstado(true);
        usuario1.setUltimoInicio(LocalDateTime.now().minusHours(2));
        usuario1.setRol(obtenerRolUsuario(1));

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setDni("87654321B");
        usuario2.setNombre("María García");
        usuario2.setCorreo("maria@example.com");
        usuario2.setContraseña("pass456");
        usuario2.setFechaDeAlta(LocalDateTime.now().minusDays(15));
        usuario2.setEstado(true);
        usuario2.setUltimoInicio(LocalDateTime.now().minusDays(1));
        usuario2.setRol(obtenerRolUsuario(2));

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setDni("11223344C");
        usuario3.setNombre("Carlos López");
        usuario3.setCorreo("carlos@example.com");
        usuario3.setContraseña("pass789");
        usuario3.setFechaDeAlta(LocalDateTime.now().minusDays(5));
        usuario3.setEstado(false);
        usuario3.setUltimoInicio(LocalDateTime.now().minusDays(3));
        usuario3.setRol(obtenerRolUsuario(3));
        
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        
        return usuarios;
    }
    
    private Rol obtenerRolUsuario(int usuarioId) {
        ArrayList<Rol> todosLosRoles = rolesComponent.obtenerRoles();
        ArrayList<Integer> rolesIds = usuariosRolesComponent.obtenerRolesDeUsuario(usuarioId);
        
        if (!rolesIds.isEmpty()) {
            int rolId = rolesIds.get(0);
            for (Rol rol : todosLosRoles) {
                if (rol.getId() == rolId) {
                    return rol;
                }
            }
        }
        
        return null;
    }
}