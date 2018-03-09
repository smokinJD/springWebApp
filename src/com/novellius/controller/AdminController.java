package com.novellius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;
import com.novellius.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado){
		
		List<Admin> admins = adminService.findAll();
		Admin admin = new Admin();
		
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		model.addAttribute("admins", admins);
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model,
			RedirectAttributes rd){
		
		if (adminForm.getNombre().equals("") && adminForm.getCargo().equals("")){
			rd.addFlashAttribute("resultado", "Datos Vacios");	
		}else {
			
		
		if (adminService.saveOrUpdate(adminForm)){
			
			rd.addFlashAttribute("resultado", "Datos Insertados correctamente");
		}else{
			
			rd.addFlashAttribute("resultado", "Error Al insertar el Admin");
		}
		}
		
		
		return "redirect:/admin";
	}
	
	//esto recoge en GET {variable}
	@RequestMapping("/admin/{id}/update")
	public String showUpdate(Model model, @PathVariable("id") int id){
		
		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		return "admin";
	}
	
	@RequestMapping("/admin/{id}/delete")
	public String delete(@PathVariable("id") int id, RedirectAttributes rd){
		
		if(adminService.delete(id)){
			rd.addFlashAttribute("resultado", "Admin eliminado correctamente");
		}else {
			rd.addFlashAttribute("resultado", "error al eliminar Admin");
		}
		
		return "redirect:/admin";
	}
}
