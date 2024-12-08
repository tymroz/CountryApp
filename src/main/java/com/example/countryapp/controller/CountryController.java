package com.example.countryapp.controller;

import com.example.countryapp.model.Country;
import com.example.countryapp.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{alpha3Code}")
    public Country getCountry(@PathVariable String alpha3Code) {
        return countryService.getCountryByAlpha3Code(alpha3Code);
    }
}