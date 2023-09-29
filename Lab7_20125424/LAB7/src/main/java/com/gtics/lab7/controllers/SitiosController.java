package com.gtics.lab7.controllers;

import gtics.lab6_20125424.repository.SiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/site")
public class SitiosController {

    final SiteRepository sitiosRepository;

    public SitiosController(SiteRepository sitiosRepository) {
        this.sitiosRepository = sitiosRepository;
    }

    @GetMapping(value = {"/listar", ""})
    public String listar (Model model){
        model.addAttribute("page","sitios");
        model.addAttribute("listarsitios",sitiosRepository.findAll());
        return "sitios/list";
    }



}