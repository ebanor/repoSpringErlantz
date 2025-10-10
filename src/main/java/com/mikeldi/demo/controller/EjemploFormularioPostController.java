package com.mikeldi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Persona;


@Controller
@RequestMapping("/ejemploformulario")
public class EjemploFormularioPostController {

	final String plantilla_formulario_post = "ejemploformulario";


	@GetMapping("/mostrarformulario")
	public String mostrarForm(Model model) {
		model.addAttribute("persona", new Persona());
		return plantilla_formulario_post;
	}

	final String vista_resultado = "resultadoformulario";
	@PostMapping("/aniadirpersona")
	public ModelAndView aniadirPersona(@ModelAttribute("persona") Persona persona) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(vista_resultado);
		persona.setApellidos(persona.getApellidos().toUpperCase());
		mav.addObject("persona", persona);
		return mav;
	}

}