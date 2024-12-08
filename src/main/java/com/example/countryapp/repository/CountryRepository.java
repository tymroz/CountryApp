package com.example.countryapp.repository;

import com.example.countryapp.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {
    Optional<Country> findByAlpha3Code(String alpha3Code);
}