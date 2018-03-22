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
  public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {

    List<Admin> admins = adminService.findAll();
    Admin admin = new Admin();

    model.addAttribute("admin", admin);
    model.addAttribute("resultado", resultado);
    model.addAttribute("admins", admins);
    return "admin";
  }

  @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
  public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model,
      RedirectAttributes rd) {

    if (adminForm.getNombre().equals("") && adminForm.getCargo().equals("")) {
      rd.addFlashAttribute("resultado", "Datos Vacios");
    } else {


      adminService.saveOrUpdate(adminForm);

      rd.addFlashAttribute("resultado", "Datos Insertados correctamente");
    }


    return "redirect:/admin";
  }

  @RequestMapping("/admin/{id}/update")
  public String showUpdate(Model model, @PathVariable("id") int id) {

    Admin admin = adminService.findById(id);
    model.addAttribute("admin", admin);
    return "admin";
  }

  @RequestMapping("/admin/{id}/delete")
  public String delete(@PathVariable("id") int id, RedirectAttributes rd) {

    adminService.delete(id);
    rd.addFlashAttribute("resultado", "Admin eliminado correctamente");


    return "redirect:/admin";
  }
}
