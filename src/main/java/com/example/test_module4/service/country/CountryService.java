package com.example.test_module4.service.country;

import com.example.test_module4.model.Country;
import com.example.test_module4.repository.ICountryRepository;
import com.example.test_module4.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }



    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
