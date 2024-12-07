package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Country {

    @Id
    private String alpha3Code;
    private String nameCommon;
    private String nameOfficial;
    @ElementCollection
    private List<String> capital;
    private String region;
    private String subregion;
    @ElementCollection
    private Map<String, Currency> currencies;
    @ElementCollection
    private Map<String, String> languages;
    private int population;
    @ElementCollection
    private List<String> borders;
    @ElementCollection
    private List<String> timezones;

    // Gettery i Settery
    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getNameCommon() {
        return nameCommon;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setNameCommon(String nameCommon) {
        this.nameCommon = nameCommon;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }
}
