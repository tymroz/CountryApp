package com.example.countryapp;

import com.example.countryapp.model.Country;
import com.example.countryapp.repository.CountryRepository;
import com.example.countryapp.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void testFetchAndSaveCountry() {
        Country country = countryService.getCountryByAlpha3Code("USA");
        assertNotNull(country);
        assertEquals("USA", country.getAlpha3Code());

        // Sprawdzenie zapisu w bazie
        Optional<Country> savedCountry = countryRepository.findByAlpha3Code("USA");
        assertTrue(savedCountry.isPresent());
    }
}