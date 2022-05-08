package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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

   /* @RequestMapping(value = "/{id}")
    public String view(@PathVariable("id") Integer id, ModelMap modelMap) {
        Tour tour = tourRepository.findById(id).get();
        modelMap.addAttribute("tours", tour);
        return "/ :: view";
    }*/
    @GetMapping("{productId}")
    public ModelAndView product(@PathVariable Integer productId) {
        return this.tourRepository.findById(productId)
                .map(product -> new ModelAndView("home/tour",
                        Map.of("product", product), HttpStatus.OK))
                .orElseGet(() -> new ModelAndView("errors/404",
                        Map.of("error", "Couldn't find a product"), HttpStatus.NOT_FOUND));
    }

}
