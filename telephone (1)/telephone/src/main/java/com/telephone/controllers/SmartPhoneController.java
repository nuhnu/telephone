package com.telephone.controllers;

import com.telephone.entities.SmartPhone;
import com.telephone.services.SmartPhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class SmartPhoneController {

    private final SmartPhoneService service;

    public SmartPhoneController(SmartPhoneService service) {
        this.service = service;
    }

    @GetMapping
    public String listPhones(Model model) {
        model.addAttribute("smartphones", service.findAll());
        return "list_smartPhone";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("smartphone", new SmartPhone());
        return "add_smartPhone";
    }

    @PostMapping("/save")
    public String savePhone(@ModelAttribute SmartPhone smartphone) {
        service.save(smartphone);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deletePhone(@ModelAttribute SmartPhone smartphone) {
        service.delete(smartphone.getId());
        return "redirect:/";
    }
}