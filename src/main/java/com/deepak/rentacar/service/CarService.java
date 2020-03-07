package com.deepak.rentacar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.deepak.rentacar.model.Car;
import com.deepak.rentacar.repository.CarRepository;

@Service
public class CarService {

	private CarRepository repository;

	@Autowired
	public CarService(CarRepository repository) {
		this.repository = repository;
	}

	public List<Car> showAllCars() {
		return repository.findAll();
	}

	public List<Car> showAllCarsSorted(String sorting, String property) {
		String[] properties = property.split(",");
		Sort sort = Sort.by(Sort.Direction.fromString(sorting), properties);
		return repository.findAll(sort);
	}

	public Car findCarById(Long id) {		
		 Optional<Car> car = repository.findById(id);
		 return car.isPresent() ? car.get() : null;
	}

}
