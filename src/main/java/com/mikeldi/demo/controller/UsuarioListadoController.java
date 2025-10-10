package com.mikeldi.demo.controller;

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
import com.mikeldi.demo.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioListadoController {

    final String plantillaFormularioListado = "listadousuarios";
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static final Log LOG = LogFactory.getLog(UsuarioListadoController.class);

    @Autowired
    @Qualifier("usuariosComponent")
    UsuariosComponent usuariosComponent;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuario", new Usuario());
        usuarios = usuariosComponent.obtenerUsuarios();
        model.addAttribute("usuarios", usuarios);
        return plantillaFormularioListado;
    }

    @PostMapping("/aniadirusuario")
    public ModelAndView aniadirUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(plantillaFormularioListado);
        usuarios.add(usuario);
        LOG.info("Añadido usuario: " + usuario.getNombre() + " - " + usuario.getCorreo());
        mav.addObject("usuarios", usuarios);
        mav.addObject("usuario", new Usuario());
        return mav;
    }
}