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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;
import com.novellius.service.AdminService;
import com.novellius.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {
  
  @Autowired
  private AdminService adminService;
  
  @Autowired
  private DireccionService direccionService;

  @RequestMapping("/direccion/{id}")
  public String getAll(Model model, @PathVariable("id") int id, @ModelAttribute("resultado") String resultado){
    
    Admin admin = adminService.findById(id);
    model.addAttribute("admin", admin);
    
    model.addAttribute("direccion", new Direccion());
    model.addAttribute("resultado", resultado);
    model.addAttribute("direcciones", direccionService.findAll(id));
    
    return "direccion";
  }
  
  @RequestMapping("/direccion/save")
  public String save(Model model, @ModelAttribute("admin") Admin admin
      ,@ModelAttribute("direccion") Direccion direccion, RedirectAttributes rd){
    
    direccionService.save(admin, direccion);
    rd.addFlashAttribute("resultado", "Datos Insertados correctamente");
    
    return "redirect:/direccion/" + admin.getId();
  }

}
