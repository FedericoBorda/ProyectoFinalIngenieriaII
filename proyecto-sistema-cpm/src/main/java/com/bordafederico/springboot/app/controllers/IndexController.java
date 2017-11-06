package com.bordafederico.springboot.app.controllers;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class IndexController {
	
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrar(Model model) {		
		model.addAttribute("titulo", "Página de Inicio");
		model.addAttribute("bienvenido", "Bienvenido");
		model.addAttribute("sistemacpm", "Sistema Centralizado para Profesionales Médicos");
		return "index";
	}

}
