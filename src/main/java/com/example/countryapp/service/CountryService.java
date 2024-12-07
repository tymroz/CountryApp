package com.example.countryapp.service;

import com.example.countryapp.model.Country;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
        this.restTemplate = new RestTemplate();
    }

    public Country getCountryByAlpha3Code(String alpha3Code) {
        return countryRepository.findByAlpha3Code(alpha3Code).orElseGet(() -> fetchAndSaveCountry(alpha3Code));
    }

    // to do ..
}