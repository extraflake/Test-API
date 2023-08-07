package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Region;
import com.example.demo.services.RegionService;

@Controller
@RequestMapping("region") // http://localhost:8088/region
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping // http://localhost:8088/region
    public String index(Model model) {
        model.addAttribute("regions", regionService.Get());
        return "region/index";
    }

    // GET
    @GetMapping(value = {"form", "form/{id}"}) // http://localhost:8088/region/form/
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if(id != null) {
            model.addAttribute("region", regionService.Get(id));
        } else {
            model.addAttribute("region", new Region());
        }
        return "region/form";
    }

    // POST
    @PostMapping("save") // http://localhost:8088/region/save
    public String submit(Region region) {
        Boolean result = regionService.Save(region);
        if(result) {
            return "redirect:/region";
        } else {
            return "region/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        regionService.Delete(id);
        return "redirect:/region";
    }
}
