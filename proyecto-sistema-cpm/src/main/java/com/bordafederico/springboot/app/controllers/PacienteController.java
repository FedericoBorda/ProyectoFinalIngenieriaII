package com.bordafederico.springboot.app.controllers;



import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bordafederico.springboot.app.models.entity.ObrasPlanesForm;
import com.bordafederico.springboot.app.models.entity.Paciente;
import com.bordafederico.springboot.app.models.entity.Plan;
import com.bordafederico.springboot.app.models.service.IObraSocialService;
import com.bordafederico.springboot.app.models.service.IPacienteService;
import com.bordafederico.springboot.app.models.service.IPlanService;

@Controller   //marcamos asi que la clase es de tipo controlador
@SessionAttributes("paciente") //al implementar esto lo que hace es que guardar el objeto paciente en la session hasta que el mismo persista completamente en la bd
public class PacienteController {
	
	@Autowired  //busca un componente registrado en el contenedor registrado como PacienteDao
	//@Qualifier("pacienteDaoJPA")
	private IPacienteService pacienteService;
	//private IPacienteDao pacienteDao; lo comentamos porque ahora usamos el Service
	
	@Autowired
	private IObraSocialService obraSocialService;
	
	@Autowired
	private IPlanService planService;
	
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
		model.put("obrasociales",obraSocialService.findAll());
		//model.put("obrasPlanesForm", new ObrasPlanesForm());
		model.put("planes", planService.findAll());
		model.put("titulo", "Formulario de Alta de Paciente");
		
		return "formpaciente";
	}
	
	
	//METODO QUE PERMITE EDITAR UN PACIENTE
	@RequestMapping(value="/formpaciente/{dni_paciente}")
	public String editarPaciente(@PathVariable(value="dni_paciente") Long dni_paciente, Map<String, Object> model, RedirectAttributes flash) {
		
		Paciente paciente = null;
		//ObraSocial obrasocial= null;
		
		
		
		if(dni_paciente > 0) {
			paciente = pacienteService.findOnePaciente(dni_paciente);
			
			//System.out.println("paciente es: " + pacienteService.findOnePaciente(dni_paciente).getPlan().getObra_social().getNombre_obra_social());
			if(paciente == null) {
				flash.addFlashAttribute("error", "El Paciente no existe en la Base de Datos");
				return "redirect:/listar";
			}
		}else {
			flash.addFlashAttribute("error", "El DNI del paciente no puede ser 0 o menor que 0");
			return "redirect:/listar";
		}
		model.put("paciente", paciente);
		model.put("obrasociales",obraSocialService.findAll());
		model.put("planes", planService.findAll());//obrasocial.getPlanes_x_obrasocial()
		model.put("titulo", "Editar Paciente");
		
		return "formpaciente";
	}
	
	
	//METODO QUE REALIZA LA PARTE DEL POST DE LA CREACION DEL PACIENTE PERSISTIENDO EL MISMO EN LA BD
	@RequestMapping(value="/formpaciente", method=RequestMethod.POST)
	public String guardarPaciente(@Valid Paciente paciente, BindingResult resultado, Model model, RedirectAttributes flash, SessionStatus status) {//@valid habilita la validacion en el objeto mapeado al form	
		
		if(resultado.hasErrors()) {//si el resultado contiene errores retornamos al formulario
			model.addAttribute("titulo", "Formulario de Alta de Paciente");
			
			return "formpaciente";
		}
		
		
		//aca guardo en el mensajeFlash el resultado de la pregunta, si es distinto de null guardo "paciente editado con exito", sino guardo lo otro
		//System.out.println("A paciente= " + paciente.getDni_paciente());
		String mensajeFlash = (paciente.getDni_paciente() != null)? "Paciente guardado con éxito!!" : "Paciente creado con éxito!!";
		//System.out.println("B paciente= " + paciente.getDni_paciente() + " " + mensajeFlash);
		
		pacienteService.savePaciente(paciente);	
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	
	//METODO QUE ELIMINA UN PACIENTE DE LA BD
	@RequestMapping(value="/eliminar/{dni_paciente}")
	public String eliminarPaciente(@PathVariable(value="dni_paciente") Long dni_paciente, RedirectAttributes flash){
		
		if(dni_paciente > 0) {
			pacienteService.deletePaciente(dni_paciente);
			flash.addFlashAttribute("success", "Paciente eliminado con éxito!!");
		}
		return "redirect:/listar";
	}
	
	
	//@RequestMapping
	//public Model listarObrasSociales(Model model) {
		//model.addAttribute("obrasociales", obraSocialService.findAll());
		//model.addAttribute("obrasPlanesForm", new ObrasPlanesForm());
		//return model;
	//}
	
	
	@RequestMapping(value="/cascada", method=RequestMethod.POST)
	public @ResponseBody List<Plan> cascada(@RequestBody ObrasPlanesForm form){		
		return obraSocialService.findOneOSocial(form.getObrasocial()).getPlanes_x_obrasocial();
	}
	
	
	
	
	
}
