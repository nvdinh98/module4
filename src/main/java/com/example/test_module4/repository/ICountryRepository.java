package com.example.test_module4.repository;

import com.example.test_module4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Long> {
}
