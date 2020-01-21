package com.example.arabasozlugu.ArabaSozlugu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.arabasozlugu.ArabaSozlugu.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, String>{

}
