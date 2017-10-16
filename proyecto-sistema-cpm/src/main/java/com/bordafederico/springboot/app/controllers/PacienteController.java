package com.bordafederico.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bordafederico.springboot.app.models.dao.IPacienteDao;

@Controller   //marcamos asi que la clase es de tipo controlador
public class PacienteController {
	
	@Autowired  //busca un componente registrado en el contenedor registrado como PacienteDao
	@Qualifier("pacienteDaoJPA")
	private IPacienteDao pacienteDao;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {		
		model.addAttribute("titulo", "Listado de Pacientes");
		model.addAttribute("pacientes", pacienteDao.findAll());
		return "listar";
	}

}
