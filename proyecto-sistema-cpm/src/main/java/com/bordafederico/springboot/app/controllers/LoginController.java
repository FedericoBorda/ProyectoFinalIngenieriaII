package com.bordafederico.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bordafederico.springboot.app.models.entity.Usuario;
import com.bordafederico.springboot.app.models.model.User;
import com.bordafederico.springboot.app.models.service.UserService;
//import com.bordafederico.springboot.app.models.model.UserCredential;




@Controller
public class LoginController {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("titulo", " Pagina de logueo");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		modelAndView.addObject("titulo", " Pagina de registro");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"Ya hay un usuario registrado con el Email proporcionado");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Usuario registrado correctamente");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	//PRUEBO CONTROLLER USUARIO USER
	@RequestMapping(value="/user/homeuser", method = RequestMethod.GET)
	public ModelAndView homeUser(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		modelAndView.addObject("userName", "Bienvenido " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userMessage","Contenido disponible para User Role");
		modelAndView.setViewName("user/homeuser");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView inicio(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());		
		modelAndView.addObject("userName", "Bienvenido " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("homeMessage","Contenido disponible para todos");
		modelAndView.addObject("titulo", " Página de Inicio");
		modelAndView.addObject("bienvenido", "Bienvenido");
		modelAndView.addObject("sistemacpm", "Sistema Centralizado para Profesionales Médicos");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	

	
	/*LO QUE TENIA ANTES DE MODIFICAR TOddO
	@GetMapping(value="/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	
	
	@GetMapping(value="/login")
	public String showLoginForm(
			Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout){
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());
		return "login";
	}
	
	
	@PostMapping(value="/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
		
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			return "redirect:/index";
		}
		
		return "redirect:/login?error";
	}*/
}
