package com.example.test_module4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private Double area;
    private int population;
    private Double gdp;
    private String description;
}
