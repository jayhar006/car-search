package com.car.search.repository;

import com.car.search.entity.Car;

import java.util.List;

public interface CarRepositoryCustom {

    List<Car> findCarByLengthWeightVelocityColor(int length, int weight, int velocity, String color);

}
