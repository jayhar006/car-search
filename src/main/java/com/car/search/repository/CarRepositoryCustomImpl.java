package com.car.search.repository;

import com.car.search.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryCustomImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Car> findCarByLengthWeightVelocityColor(int length, int weight, int velocity, String color) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);

        Path<String> lengthPath = car.get("length");
        Path<String> weightPath = car.get("weight");
        Path<String> velocityPath = car.get("velocity");
        Path<String> colorPath = car.get("color");

        List<Predicate> predicates = new ArrayList<>();
        if (length != 0)
            predicates.add(cb.equal(lengthPath, String.valueOf(length)));
        if (weight != 0)
            predicates.add(cb.equal(weightPath, String.valueOf(weight)));
        if (velocity != 0)
            predicates.add(cb.equal(velocityPath, String.valueOf(velocity)));
        if (!color.isEmpty())
            predicates.add(cb.like(colorPath, color));

        query.select(car)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
