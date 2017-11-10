package com.bordafederico.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bordafederico.springboot.app.models.entity.TurnoDisponible;
import com.bordafederico.springboot.app.models.service.ITurnoDisponibleService;

@Controller
@SessionAttributes("turnodisponible")
public class TurnoDisponibleController {
	
	@Autowired
	private ITurnoDisponibleService turnodisponibleService;
	
	
	@RequestMapping(value="/formturnodisponible")
	public String crearTD(Map<String, Object> model) {
		
		TurnoDisponible turnodisponible = new TurnoDisponible();
		model.put("turnodiponible", turnodisponible);
		model.put("titulo", "Calendario de Asignación de Turnos");
		
		return "formturnodisponible";
	}

}
