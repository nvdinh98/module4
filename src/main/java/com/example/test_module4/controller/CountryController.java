package com.example.test_module4.controller;

import com.example.test_module4.model.Country;
import com.example.test_module4.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping()
    public ResponseEntity<Iterable<Country>> showAll() {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }
}
