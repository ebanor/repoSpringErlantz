package com.mikeldi.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mikeldi.demo.component.UsuariosComponent;
import com.mikeldi.demo.component.RolesComponent;
import com.mikeldi.demo.model.Usuario;
import com.mikeldi.demo.model.Rol;

@Controller
@RequestMapping("/usuarios")
public class UsuarioListadoController {

    final String plantillaFormularioListado = "usuarioslistado";
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static final Log LOG = LogFactory.getLog(UsuarioListadoController.class);

    @Autowired
    @Qualifier("usuariosComponent")
    UsuariosComponent usuariosComponent;
    
    @Autowired
    @Qualifier("rolesComponent")
    RolesComponent rolesComponent;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuario", new Usuario());
        if (usuarios.isEmpty()) {
            usuarios = usuariosComponent.obtenerUsuarios();
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", rolesComponent.obtenerRoles());
        return plantillaFormularioListado;
    }

    @PostMapping("/aniadirusuario")
    public ModelAndView aniadirUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(plantillaFormularioListado);

        // Asignar ID único
        int maxId = usuarios.stream().mapToInt(Usuario::getId).max().orElse(0);
        usuario.setId(maxId + 1);

        LocalDateTime ahora = LocalDateTime.now();
        usuario.setFechaDeAlta(ahora);
        usuario.setUltimoInicio(ahora);
        usuario.setEstado(true);

        ArrayList<Rol> todosLosRoles = rolesComponent.obtenerRoles();
        for (Rol rol : todosLosRoles) {
            if (rol.getId() == usuario.getRol().getId()) {
                usuario.setRol(rol);
                break;
            }
        }

        usuarios.add(usuario);
        LOG.info("Añadido usuario: " + usuario.getNombre() + " - " + usuario.getCorreo() + " con rol: " + usuario.getRol().getNombreRol());

        mav.addObject("usuarios", usuarios);
        mav.addObject("usuario", new Usuario());
        mav.addObject("roles", rolesComponent.obtenerRoles());
        return mav;
    }
}