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


import com.bordafederico.springboot.app.models.entity.Paciente;
import com.bordafederico.springboot.app.models.service.IPacienteService;

@Controller   //marcamos asi que la clase es de tipo controlador
@SessionAttributes("paciente") //al implementar esto lo que hace es que guardar el objeto paciente en la session hasta que el mismo persista completamente en la bd
public class PacienteController {
	
	@Autowired  //busca un componente registrado en el contenedor registrado como PacienteDao
	//@Qualifier("pacienteDaoJPA")
	private IPacienteService pacienteService;
	//private IPacienteDao pacienteDao; lo comentamos porque ahora usamos el Service
	
	//METODO QUE LISTA LOS PACIENTE
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {		
		model.addAttribute("titulo", "Listado de Pacientes");
		model.addAttribute("pacientes", pacienteService.findAll());
		return "listar";
	}
	
	//METODO QUE MUESTRA EL FORM DE CREAR PACIENTE
	@RequestMapping(value="/formpaciente")
	public String crearPaciente(Map<String, Object> model) {		
		
		Paciente paciente = new Paciente();
		model.put("paciente", paciente);
		model.put("tituloform", "Formulario de Alta de Paciente");
		
		return "formpaciente";
	}
	
	
	//METODO QUE PERMITE EDITAR UN PACIENTE
	@RequestMapping(value="/formpaciente/{dni_paciente}")
	public String editarPaciente(@PathVariable(value="dni_paciente") Long dni_paciente, Map<String, Object> model) {
		
		Paciente paciente = null;
		
		if(dni_paciente > 0) {
			paciente = pacienteService.findOnePaciente(dni_paciente);
		}else {
			return "redirect:/listar";
		}
		model.put("paciente", paciente);
		model.put("tituloform", "Editar Paciente");
		
		return "formpaciente";
	}
	
	
	//METODO QUE REALIZA LA PARTE DEL POST DE LA CREACION DEL PACIENTE PERSISTIENDO EL MISMO EN LA BD
	@RequestMapping(value="/formpaciente", method=RequestMethod.POST)
	public String guardarPaciente(@Valid Paciente paciente, BindingResult resultado, Map<String, Object> model, SessionStatus status) {//@valid habilita la validacion en el objeto mapeado al form	
		
		if(resultado.hasErrors()) {//si el resultado contiene errores retornamos al formulario
			model.put("tituloform", "Formulario de Alta de Paciente");
			return "formpaciente";
		}
		
		pacienteService.savePaciente(paciente);	
		status.setComplete();
		return "redirect:listar";
	}
	
	
	//METODO QUE ELIMINA UN PACIENTE DE LA BD
	@RequestMapping(value="/eliminar/{dni_paciente}")
	public String eliminarPaciente(@PathVariable(value="dni_paciente") Long dni_paciente){
		
		if(dni_paciente > 0) {
			pacienteService.deletePaciente(dni_paciente);
		}
		return "redirect:/listar";
	}
	

}
