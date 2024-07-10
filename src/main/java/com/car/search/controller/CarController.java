package com.car.search.controller;

import com.car.search.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("cars", carService.getCarSearch(120, 1200, 129, ""));
        return "cars";
    }

}
