package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class TourController {
    @Autowired
    private TourRepository tourRepository;
    @PostMapping("/save")
    public String save(Tour tout) {
        tourRepository.save(tout);
        return "redirect:/";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Tour findOne(Integer id) {
        return tourRepository.findById(id).get();
    }
    @RequestMapping(value = "/{id}")
    public String view(@PathVariable("id") Integer id, ModelMap modelMap) {
        Tour tour = tourRepository.findById(id).get();
        modelMap.addAttribute("tours", tour);
        return "/ :: view";
    }

}
