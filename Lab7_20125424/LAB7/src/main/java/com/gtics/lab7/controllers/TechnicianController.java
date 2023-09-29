package com.gtics.lab7.controllers;

import com.gtics.lab7.entity.Technician;
import com.gtics.lab7.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


@Controller
@RequestMapping("/tecnico")
public class TechnicianController {

    final TechnicianRepository technicianRepository;

    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"/listar", ""})
    public String listar(Model model) {
        model.addAttribute("page", "sitios");
        model.addAttribute("listartecnicos", technicianRepository.findAll());
        return "tecnico/list";
    }

    @GetMapping("/new")
    public String nuevoTechnicianFrm(Model model, @ModelAttribute("tecnico") Technician tecnico) {
        return "tecnico/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model, @ModelAttribute("tecnico") @Valid Technician tecnico, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { // Si no hay errores, se realiza el flujo normal

            if (tecnico.getTechnicianID() == 0) {
                attr.addFlashAttribute("msg", "Producto creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
            }
            technicianRepository.save(tecnico);
            return "redirect:/tecnico";


        } else { // Hay al menos 1 error
            System.out.println("Hay error");
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println("Campo con error: " + error.getField());
                System.out.println("Mensaje de error: " + error.getDefaultMessage());
            }
            return "tecnico/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("tecnico") Technician tecnico,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            tecnico = optionalTechnician.get();
            model.addAttribute("tecnico", tecnico);
            return "tecnico/editFrm";
        } else {
            return "redirect:/tecnico";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technicianRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Técnico borrado exitosamente");
        }
        return "redirect:/product";

    }
}