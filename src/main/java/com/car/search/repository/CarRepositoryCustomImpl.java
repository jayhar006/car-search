package com.car.search.repository;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryCustomImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Car> findCarByLengthWeightVelocityColor(SearchQueryParameters searchQueryParameters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);

        Path<String> lengthPath = car.get("length");
        Path<String> weightPath = car.get("weight");
        Path<String> velocityPath = car.get("velocity");
        Path<String> colorPath = car.get("color");

        List<Predicate> predicates = new ArrayList<>();
        if (searchQueryParameters.getLength() != 0)
            predicates.add(cb.equal(lengthPath, String.valueOf(searchQueryParameters.getLength())));
        if (searchQueryParameters.getWeight() != 0)
            predicates.add(cb.equal(weightPath, String.valueOf(searchQueryParameters.getWeight())));
        if (searchQueryParameters.getVelocity() != 0)
            predicates.add(cb.equal(velocityPath, String.valueOf(searchQueryParameters.getVelocity())));
        if (searchQueryParameters.getColor()!= null && !searchQueryParameters.getColor().isEmpty())
            predicates.add(cb.like(colorPath, searchQueryParameters.getColor()));

        Predicate [] predicatesArray = new Predicate[predicates.size()];

        query.select(car)
                .where(cb.or(predicates.toArray(predicatesArray)));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
