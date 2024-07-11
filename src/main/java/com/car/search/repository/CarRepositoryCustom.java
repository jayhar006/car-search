package com.car.search.repository;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;

import java.util.List;

public interface CarRepositoryCustom {

    List<Car> findCarByLengthWeightVelocityColor(SearchQueryParameters searchQueryParameters);

}
