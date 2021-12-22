package com.example.test_module4.controller;

import com.example.test_module4.model.City;
import com.example.test_module4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @ModelAttribute("cityList")
    public Iterable<City> cityList(){
        return cityService.findAll();
    }

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<City>> showAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findOneCityById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<City> editCity(@RequestBody City city, @PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (city.getId() != null) {
                city.setId(id);
            }
            return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){
       Optional<City> cityOptional = cityService.findById(id);
       if (!cityOptional.isPresent()){
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       cityService.remove(id);
       return new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);
    }

}
