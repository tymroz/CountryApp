package com.example.countryapp.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Currency {

    private String name;
    private String symbol;

    public Currency(String unknown, String unknown1) {
        this.name=unknown;
        this.symbol=unknown1;
    }

    public Currency() {

    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
