package com.mikeldi.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.component.EjemploComponent;
import com.mikeldi.demo.model.Persona;

@Controller
@RequestMapping("/ejemplos")
public class EjemploFormularioListadoController {
	final String plantillaFormularioListado = "formulariolistado";
	private ArrayList<Persona> personas= new ArrayList<Persona>();
	private static final Log LOG = LogFactory.getLog(EjemploFormularioListadoController.class);
	@Autowired
	@Qualifier("ejemploComponent")
	EjemploComponent ejemplo;


	@GetMapping("/mostrarformulario")
	public String mostrarForm(Model model) {
		model.addAttribute("persona", new Persona());
		personas = ejemplo.getPersonas();
		model.addAttribute("personas", personas);
		return plantillaFormularioListado;
	}
	
	@PostMapping("/aniadirpersona")
	public ModelAndView aniadirPersona(@ModelAttribute("persona") Persona persona) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(plantillaFormularioListado);
		personas.add(persona);
		LOG.info("Añadida persona: " + persona.getNombre() + " " + persona.getApellidos());
		mav.addObject("personas", personas);
		mav.addObject("persona", new Persona());
		return mav;
	}
	
	
	
}











