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
import com.bordafederico.springboot.app.models.entity.Plan;
import com.bordafederico.springboot.app.models.service.IObraSocialService;
import com.bordafederico.springboot.app.models.service.IPlanService;

@Controller
@RequestMapping("/plan") // esto significa que va a tener una url basica de primer nivel
@SessionAttributes("plan")
public class PlanController {

	@Autowired
	private IObraSocialService obraSocialService;

	@Autowired
	private IPlanService planService;

	@RequestMapping(value = "/formplan/{id_obra_social}") // aca relacionamos la plan con la obra social
	public String crearPlan(@PathVariable(value = "id_obra_social") Long id_obra_social, Map<String, Object> model,
			RedirectAttributes flash) {

		ObraSocial obrasocial = obraSocialService.findOneOSocial(id_obra_social);
		if (obrasocial == null) {
			flash.addFlashAttribute("error", "La Obra Social no exite en la Base de Datos");
			return "redirect:/listarobrasocial";
		}

		Plan plan = new Plan();
		plan.setObra_social(obrasocial);// aca relacionamos el plan con la obra social
		
		model.put("plan", plan);
		model.put("titulo", "Alta de Plan");

		return "plan/formplan";
	}

	// EDITAR Plan
	@RequestMapping(value = "/formplan/{id_obra_social}/{id_plan}")
	public String editarPlan(
			@PathVariable(value = "id_obra_social") Long id_obra_social,
			@PathVariable(value = "id_plan") Long id_plan, Map<String, Object> model,
			RedirectAttributes flash) {

		ObraSocial obrasocial = null;
		Plan plan = null;

		if (id_obra_social >0 && id_plan > 0) {
			obrasocial = obraSocialService.findOneOSocial(id_obra_social);
			plan = planService.findOnePlan(id_plan);
			
			if (obrasocial == null) {
				flash.addFlashAttribute("error", "La Obra Social no existe en la Base de Datos");
				return "redirect:/listarobrasocial";
			}
			
			if (plan == null) {
				flash.addFlashAttribute("error", "El Plan no existe en la Base de Datos");
				return "redirect:/listarobrasocial";
			}			
			
		} else {
			flash.addFlashAttribute("error", "El id del Plan u Obra Social no puede ser 0 o menor que 0");
			return "redirect:/detalleobrasocial";
		}
		
		plan.setObra_social(obrasocial);
		model.put("plan", plan);
		model.put("titulo", "Editar Plan");

		return "plan/formplan";
	}

	
	// GUARDAR Plan
	@RequestMapping(value = "/formplan", method = RequestMethod.POST)
	public String guardarPlan(@Valid Plan plan, BindingResult resultado, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (resultado.hasErrors()) {
			model.addAttribute("titulo", "Alta de Plan");
			return "plan/formplan";
		}

		String mensajeFlash = (plan.getId_plan() != null) ? "Plan editado con éxito!!" : "Plan creado con éxito!!";
			
		planService.savePlan(plan);				
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/listarobrasocial";
	}
	
	
	// ELIMINAR Plan
	@RequestMapping(value="/eliminarplan/{id_plan}") 
	public String eliminarPlan(@PathVariable(value="id_plan") Long id_plan, RedirectAttributes flash){
	 
		if(id_plan > 0) { 
			planService.deletePlan(id_plan);
			flash.addFlashAttribute("success", "Plan eliminado con éxito!!");
		} 
		
		return "redirect:/listarobrasocial"; 
		 
	 }



}
