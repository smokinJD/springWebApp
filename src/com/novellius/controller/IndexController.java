package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//manera para añadir mas de un atributo a la session
//@SessionAttributes({"Bienvenida","mensaje"});
@SessionAttributes("Bienvenida")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("Bienvenida", "Hola estas visitando nuestra pagina!!");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout(Model model){
		model.addAttribute("mensaje", "Bienvenido a la pagina About");
		return "about";
	}
	
	@RequestMapping("/login")
	public String login(){
	  
	  return "login";
	}
	
	@RequestMapping("/logout")
    public String logout(){
      
      return "/";
    }
	
}
