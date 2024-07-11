package com.car.search.service.impl;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;
import com.car.search.repository.CarRepository;
import com.car.search.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service("carService")
public class CarServiceImplementation implements CarService {


    @Autowired
    CarRepository carRepository;


    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarSearch(SearchQueryParameters searchQueryParameters) {
        return carRepository.findCarByLengthWeightVelocityColor(searchQueryParameters);
    }
}
