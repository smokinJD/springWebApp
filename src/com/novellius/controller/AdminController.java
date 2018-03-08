package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado){
		
		Admin admin = new Admin();
		
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model,
			RedirectAttributes rd, @RequestParam("estado") String estado){
		//Crea un objeto Atributo en el cual mete los datos del form. Ejemplo tines en el system.out.print de abajo que hace referencia a adminForm
		//model.addAttribute("adminForm", adminForm);
		
		System.out.println(adminForm);
		//El Request Param Sirve para Recoger datos del form normal sin los tag de JSTL
		System.out.println("Request param: "+ estado);
		
		rd.addFlashAttribute("resultado", "Datos Insertados correctamente");
		return "redirect:/admin";
	}
}
