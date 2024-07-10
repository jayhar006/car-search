package com.car.search.service;

import com.car.search.entity.Car;

import java.util.List;

public interface CarService {



    List<Car> getAllCars();

    List<Car> getCarSearch(int length, int weight, int velocity, String color);


}
