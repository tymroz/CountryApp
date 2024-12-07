package com.example.countryapp.service;

import com.example.countryapp.model.Country;
import com.example.countryapp.model.Currency;
import com.example.countryapp.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;

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

    private Country fetchAndSaveCountry(String alpha3Code) {
        String apiUrl = "https://restcountries.com/v3.1/alpha/" + alpha3Code;

        // Wywołanie do API i deserializacja odpowiedzi jako lista
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        List<Map<String, Object>> countries = response.getBody();
        if (countries != null && !countries.isEmpty()) {
            Map<String, Object> countryData = countries.get(0);
            Country country = new Country();

            // Mapowanie danych z API na obiekt Country
            country.setAlpha3Code((String) countryData.get("cioc"));

            Map<String, Object> name = (Map<String, Object>) countryData.get("name");
            country.setNameCommon((String) name.get("common"));
            country.setNameOfficial((String) name.get("official"));

            country.setCapital((List<String>) countryData.get("capital"));
            country.setRegion((String) countryData.get("region"));
            country.setSubregion((String) countryData.get("subregion"));
            country.setPopulation((Integer) countryData.get("population"));
            country.setLanguages((Map<String, String>) countryData.get("languages"));
            country.setBorders((List<String>) countryData.get("borders"));
            country.setTimezones((List<String>) countryData.get("timezones"));

            Map<String, Map<String, String>> currencies = (Map<String, Map<String, String>>) countryData.get("currencies");
            Map<String, Currency> currencyMap = new java.util.HashMap<>();
            for (Map.Entry<String, Map<String, String>> entry : currencies.entrySet()) {
                String currencyCode = entry.getKey();
                Map<String, String> currencyDetails = entry.getValue();
                Currency currency = new Currency(currencyDetails.get("name"), currencyDetails.get("symbol"));
                currencyMap.put(currencyCode, currency);
            }
            country.setCurrencies(currencyMap);

            // to do saving in database ..
            return country;
        } else {
            throw new RuntimeException("No country data found for alpha3Code: " + alpha3Code);
        }
    }
}