package com.car.search.controller;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;
import com.car.search.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("search", new SearchQueryParameters());
        List<Car> cars = new ArrayList<>();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @PostMapping("/cars")
    public String searchCars(@ModelAttribute("search") SearchQueryParameters searchQueryParameters, Model model){
        if(searchQueryParameters != null)
            model.addAttribute("cars", carService.getCarSearch(searchQueryParameters.getLength(), searchQueryParameters.getWeight(), searchQueryParameters.getVelocity(), searchQueryParameters.getColor()));
        return "cars";
    }

}
