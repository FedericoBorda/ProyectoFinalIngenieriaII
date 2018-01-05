package com.bordafederico.springboot.app.controllers;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.bordafederico.springboot.app.models.entity.TurnoDisponible;
import com.bordafederico.springboot.app.models.service.ITurnoDisponibleService;

@Controller
@SessionAttributes("turnodisponible")
public class TurnoDisponibleController {
	
	@Autowired
	private ITurnoDisponibleService turnodisponibleService;
	
	
	@RequestMapping(value="/listarturnodisponible", method=RequestMethod.GET)
	public String listarTD(Model model) {		
		model.addAttribute("titulo", "Turnos Activos");
		model.addAttribute("turnosdisponibles", turnodisponibleService.findAll());
		return "listarturnodisponible";
	}
	
	
	@RequestMapping(value="/formturnodisponible")
	public String crearTD(Map<String, Object> model) {
		
		TurnoDisponible turnodisponible = new TurnoDisponible();
		model.put("turnodiponible", turnodisponible);
		model.put("titulo", "Calendario de Asignación de Turnos");
		
		return "formturnodisponible";
	}

	
	
	@RequestMapping(value="/formturnodisponible", method=RequestMethod.POST)
	public String guardarTD(@Valid TurnoDisponible turnodisponible, BindingResult resultado, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(resultado.hasErrors()) {
			model.addAttribute("titulo", "Calendario de Asignación de Turnos");
			return "formturnodisponible";
		}
		
		String mensajeFlash = (turnodisponible.getId_td() != null)? "Turno editada con éxito!!" : "Turno habilitado con éxito!!";
				
		turnodisponibleService.saveTD(turnodisponible);	
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:formturnodisponible";
	}
	
	
	
	@RequestMapping(value="/busqueda", method=RequestMethod.POST)
    public @ResponseBody Long busqueda(
    		@RequestParam("anio") Long anio, 
    		@RequestParam("mes") Long mes,
    		@RequestParam("dia") Long dia,
    		@RequestParam("hora") Long hora,
    		@RequestParam("checkact") Long checkact,
    		@RequestParam("checkasig") Long checkasig){  
		
	
		
		System.out.println("Valores peticion Ajax:  anio= " + anio 
				+ " mes= " + mes + " dia= " + dia 
				+ " hora= " + hora + " checkact= " + checkact 
				+ " checkasig= " + checkasig );
		
		List<TurnoDisponible> listacompleta =  turnodisponibleService.findAll();
		int variable =  0;
		
		for (int i = 0; i < listacompleta.size(); i++) {
			
			if (listacompleta.get(i).getYear().equals(anio) 
			   		&& listacompleta.get(i).getMonth().equals(mes)
		    		&& listacompleta.get(i).getDay().equals(dia)
		    		&& listacompleta.get(i).getHour().equals(hora)
		    		&& listacompleta.get(i).getCheck_activado().equals(checkact)
		    		&& listacompleta.get(i).getCheck_asignado().equals(checkasig)) {
				System.out.println("antes de variable= " + variable);
				variable = 1;
				System.out.println("despues de variable= " + variable);
			}
		
		}
		
		System.out.println("resultado despues del for= " + variable);
		
		return (long) variable;
    }
	
	
	
	
	
	
}
