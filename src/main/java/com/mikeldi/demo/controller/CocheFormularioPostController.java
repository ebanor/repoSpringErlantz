package com.mikeldi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Coche;


@Controller
@RequestMapping("/ejemplocoche")
public class CocheFormularioPostController {

	final String plantilla_coche_post = "ejemplocoche";


	@GetMapping("/mostrarcoche")
	public String mostrarCoche(Model model) {
		model.addAttribute("coche", new Coche());
		return plantilla_coche_post;
	}

	final String vista_resultado = "resultadocoche";
	@PostMapping("/aniadircoche")
	public ModelAndView aniadirCoche(@ModelAttribute("coche") Coche coche) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(vista_resultado);
		coche.setMatricula(coche.getMatricula().toUpperCase());
		mav.addObject("coche", coche);
		return mav;
	}

}
