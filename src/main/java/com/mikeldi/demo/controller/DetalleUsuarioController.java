package com.mikeldi.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mikeldi.demo.component.RolesComponent;
import com.mikeldi.demo.model.Rol;
import com.mikeldi.demo.model.Usuario;

@Controller
@RequestMapping("/miERP")
public class DetalleUsuarioController {

    @Autowired
    RolesComponent rolesComponent;

    @GetMapping("/detalle")
    public String mostrarDetalle(@RequestParam("DNI") String dni, @RequestParam(value = "edit", defaultValue = "false") boolean edit, Model model) {
        Usuario usuario = UsuarioListadoController.usuarios.stream()
                .filter(u -> dni.equals(u.getDni()))
                .findFirst()
                .orElse(null);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("editMode", edit);
            model.addAttribute("roles", rolesComponent.obtenerRoles());
            if (edit) {
                return "editarusuario";
            } else {
                return "detalleusuario";
            }
        } else {
            return "error"; // O una página de error apropiada
        }
    }

    @PostMapping("/detalle")
    public String actualizarUsuario(@RequestParam("DNI") String dni, Usuario usuarioActualizado, RedirectAttributes redirectAttributes) {
        for (int i = 0; i < UsuarioListadoController.usuarios.size(); i++) {
            if (UsuarioListadoController.usuarios.get(i).getDni().equals(dni)) {
                // Update the user
                Usuario u = UsuarioListadoController.usuarios.get(i);
                u.setNombre(usuarioActualizado.getNombre());
                u.setCorreo(usuarioActualizado.getCorreo());
                u.setContraseña(usuarioActualizado.getContraseña());

                // Set the full Rol object
                ArrayList<Rol> todosLosRoles = rolesComponent.obtenerRoles();
                for (Rol rol : todosLosRoles) {
                    if (rol.getId() == usuarioActualizado.getRol().getId()) {
                        u.setRol(rol);
                        break;
                    }
                }

                break;
            }
        }
        redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado correctamente.");
        return "redirect:/usuarios/listar";
    }
}
