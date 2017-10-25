package com.bordafederico.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bordafederico.springboot.app.models.entity.ObraSocial;
import com.bordafederico.springboot.app.models.service.IObraSocialService;


@Controller
@SessionAttributes("obra_social")
public class ObraSocialController {
	
	@Autowired
	private IObraSocialService obraSocialService;
	
	
	@RequestMapping(value="/listarobrasocial", method=RequestMethod.GET)
	public String listarOS(Model model) {		
		model.addAttribute("titulo", "Listado de Obras Sociales");
		model.addAttribute("obrasociales", obraSocialService.findAll());
		return "listarobrasocial";
	}
	
	@RequestMapping(value="/formobrasocial")
	public String crearOS(Map<String, Object> model) {
		
		ObraSocial obrasocial = new ObraSocial();
		model.put("obrasocial", obrasocial);
		model.put("titulo", "Formulario de Alta de Obra Social");
		
		return "formobrasocial";
	}
	
	
	//EDITAR OBRA SOCIAL
	@RequestMapping(value="/formobrasocial/{id_obra_social}")
	public String editarOS(@PathVariable(value="id_obra_social") Long id_obra_social, Map<String, Object> model, RedirectAttributes flash) {
		
		ObraSocial obrasocial = null;
		
		if(id_obra_social > 0) {
			obrasocial = obraSocialService.findOneOSocial(id_obra_social);
			if(obrasocial == null) {
				flash.addFlashAttribute("error", "La Obra Social no existe en la Base de Datos");
				return "redirect:/listarobrasocial";
			}
		}else {
			flash.addFlashAttribute("error", "El id de Obra Social no puede ser 0 o menor que 0");
			return "redirect:/listarobrasocial";
		}
		model.put("obrasocial", obrasocial);
		model.put("titulo", "Editar Obra Social");
		
		return "formobrasocial";
	}
	
	
	@RequestMapping(value="/formobrasocial", method=RequestMethod.POST)
	public String guardarOS(@Valid ObraSocial obrasocial, BindingResult resultado, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(resultado.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Alta de Obra Social");
			return "formobrasocial";
		}
		
		String mensajeFlash = (obrasocial.getId_obra_social() != null)? "Obra Social guardada con éxito!!" : "Obra Social creado con éxito!!";
				
		obraSocialService.saveOSocial(obrasocial);	
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarobrasocial";
	}
	
	
	
	@RequestMapping(value="/eliminaros/{id_obra_social}")
	public String eliminarOS(@PathVariable(value="id_obra_social") Long id_obra_social, RedirectAttributes flash){
		
		if(id_obra_social > 0) {
			obraSocialService.deleteOSocial(id_obra_social);
			flash.addFlashAttribute("success", "Obra Social eliminada con éxito!!");
		}
		return "redirect:/listarobrasocial";
	}
}
