package com.car.search.service;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;

import java.util.List;

public interface CarService {



    List<Car> getAllCars();

    List<Car> getCarSearch(SearchQueryParameters searchQueryParameters);


}
