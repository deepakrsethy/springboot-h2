package com.deepak.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.rentacar.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}