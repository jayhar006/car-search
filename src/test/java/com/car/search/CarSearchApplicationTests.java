package com.car.search;

import com.car.search.entity.Car;
import com.car.search.entity.SearchQueryParameters;
import com.car.search.service.CarService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@Sql(scripts= "/test-data/data.sql")
class CarSearchApplicationTests {

	@Autowired
	CarService carService;

	@Test
	void shouldReturnEmptyResult(){
		SearchQueryParameters searchQueryParameters = SearchQueryParameters.Builder.buildEmpty();
		List<Car> result = carService.getCarSearch(searchQueryParameters);
		assertThat(result, Matchers.empty());
	}
	@Test
	void shouldReturnResultListWithSameColor(){
		SearchQueryParameters searchQueryParameters = SearchQueryParameters.Builder
				.aSearchQueryParameters()
				.withColor("Red")
				.build();
		List<Car> result = carService.getCarSearch(searchQueryParameters);

		assertThat(result, hasItems(
				hasProperty("color", is("Red"))
		));
	}
	@Test
	void shouldReturnResultListWithSameVelocity(){
		SearchQueryParameters searchQueryParameters = SearchQueryParameters.Builder
				.aSearchQueryParameters()
				.withVelocity(125)
				.build();
		List<Car> result = carService.getCarSearch(searchQueryParameters);

		assertThat(result, hasItems(
				hasProperty("velocity", is(125))
		));
	}
	@Test
	void shouldReturnResultListWithSameLength(){
		SearchQueryParameters searchQueryParameters = SearchQueryParameters.Builder
				.aSearchQueryParameters()
				.withLength(150)
				.build();
		List<Car> result = carService.getCarSearch(searchQueryParameters);

		assertThat(result, hasItems(
				hasProperty("length", is(150))
		));
	}
	@Test
	void shouldReturnResultListWithSameWeight(){
		SearchQueryParameters searchQueryParameters = SearchQueryParameters.Builder
				.aSearchQueryParameters()
				.withWeight(900)
				.build();
		List<Car> result = carService.getCarSearch(searchQueryParameters);

		assertThat(result, hasItems(
				hasProperty("weight", is(900))
		));
	}



}
