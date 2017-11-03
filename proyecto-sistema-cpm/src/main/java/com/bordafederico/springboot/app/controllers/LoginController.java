package com.bordafederico.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.bordafederico.springboot.app.models.model.UserCredential;

@Controller
public class LoginController {

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
	}
}
