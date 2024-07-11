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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @GetMapping("/cars/search")
    public String searchCars(@RequestParam(value = "length", required = false) Optional<Integer> length,
                             @RequestParam(value = "weight", required = false) Optional<Integer> weight,
                             @RequestParam(value = "velocity", required = false) Optional<Integer> velocity,
                             @RequestParam(value = "color", required = false) Optional<String> color,
                             Model model){

        SearchQueryParameters searchQueryParameters =
                SearchQueryParameters.Builder.aSearchQueryParameters()
                        .withLength(length.orElse(0))
                        .withWeight(weight.orElse(0))
                        .withVelocity(velocity.orElse(0))
                        .withColor(color.orElse("")).build();

        model.addAttribute("cars", carService.getCarSearch(searchQueryParameters));
        return "cars";
    }

}
