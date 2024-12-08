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

        Optional<Country> savedCountry = countryRepository.findByAlpha3Code("USA");
        assertTrue(savedCountry.isPresent());
    }

    @Test
    public void testFetchAndSaveCountry_InvalidCode() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            countryService.getCountryByAlpha3Code("XXX");
        });

        String expectedMessage = "Country with alpha3Code XXX not found in API.";
        assertTrue(exception.getMessage().contains(expectedMessage), "Exception message should match");
    }

    @Test
    public void testFetchAndSaveCountry_Behavior() {
        Country firstFetch = countryService.getCountryByAlpha3Code("USA");
        assertNotNull(firstFetch);
        assertEquals("USA", firstFetch.getAlpha3Code(), "Alpha3Code should match");

        Country secondFetch = countryService.getCountryByAlpha3Code("USA");
        assertNotNull(secondFetch);
        assertEquals("USA", secondFetch.getAlpha3Code(), "Alpha3Code should match");

        assertEquals(firstFetch.getNameCommon(), secondFetch.getNameCommon(), "Name common should be consistent");
        assertEquals(firstFetch.getPopulation(), secondFetch.getPopulation(), "Population should be consistent");
    }

    @Test
    public void testFetchAndSaveCountry_UpdatePopulation() {
        Country country = countryService.getCountryByAlpha3Code("USA");
        assertNotNull(country);

        country.setPopulation(400000000);
        countryRepository.save(country);

        Optional<Country> updatedCountry = countryRepository.findByAlpha3Code("USA");
        assertTrue(updatedCountry.isPresent(), "Updated country should be present in the database");

        updatedCountry.ifPresent(c -> {
            assertEquals(400000000, c.getPopulation(), "Population should be updated");
        });
    }

}