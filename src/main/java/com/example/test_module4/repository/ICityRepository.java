package com.example.test_module4.repository;

import com.example.test_module4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {
}
