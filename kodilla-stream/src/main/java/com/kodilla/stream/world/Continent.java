package com.kodilla.stream.world;


import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> countriesOnContinents = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country) {
        countriesOnContinents.add(country);
    }

    public boolean removeCountry(Country country) {
        return countriesOnContinents.remove(country);
    }

    public List<Country> getCountriesOnContinents() {
        return new ArrayList<>(countriesOnContinents);
    }
}
