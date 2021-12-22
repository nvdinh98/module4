package com.example.test_module4.service.city;

import com.example.test_module4.model.City;
import com.example.test_module4.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
   private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }
}
