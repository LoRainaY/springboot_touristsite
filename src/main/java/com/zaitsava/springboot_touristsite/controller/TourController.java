package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Controller
public class TourController {
    @Autowired
    private TourRepository tourRepository;

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "tour") Tour tour) {
        tourRepository.save(tour);
        return "redirect:/";
    }
    @PostMapping("/admin/saveTour")
    public String saveTourInModal(@ModelAttribute(name = "tour") Tour tour) {
        tourRepository.save(tour);
        return "redirect:/admin/tourList";
    }

    @PostMapping("/admin/save")
    public String saveTour(@ModelAttribute(name = "tour") Tour tour,
                           @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        tour.setImage(fileName);
        Tour savedTour = tourRepository.save(tour);
        String uploadDir = "./tour-image/" + savedTour.getId();

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);

            System.out.println(filePath.toFile().getAbsolutePath());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Невозможно сохранить файл: " + fileName);
        }


        return "admin/adminPage";
    }
    @PostMapping("/admin/delete")
    public String deleteTourInModal(@ModelAttribute(name = "tour") Tour tour) {
        tourRepository.delete(tour);
        return "redirect:/admin/tourList";
    }
/*    @PostMapping("/delete")
    public String deleteTour(Integer id ){
        tourRepository.deleteTourById(id);
        return "redirect:/tourList";
    }*/

    @GetMapping("/findOne")
    @ResponseBody
    public Tour findOne(Integer id) {
        return tourRepository.findById(id).get();
    }
    @GetMapping("/admin/findOne")
    @ResponseBody
    public Tour findOne2(Integer id) {
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
