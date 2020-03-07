package com.deepak.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.rentacar.model.Car;
import com.deepak.rentacar.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	private CarService service;

	@Autowired
	public CarController(CarService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Car>> showAllCars() {
		List<Car> cars = service.showAllCars();
		return new ResponseEntity<List<Car>>(cars, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/sort")
	public ResponseEntity<List<Car>> showAllCarsSorted(@RequestParam(defaultValue = "DESC") String sort,
			@RequestParam(defaultValue = "mfgyear") String property) {
		List<Car> cars = service.showAllCarsSorted(sort, property);
		return new ResponseEntity<List<Car>>(cars, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> showCarById(@PathVariable Long id) {
		Car car = service.findCarById(id);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

}
