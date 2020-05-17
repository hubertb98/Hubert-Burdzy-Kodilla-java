package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent northAmerica = new Continent("North America");

        //Europe
        Country poland = new Country("Poland", new BigDecimal("37846611"));
        Country portugal = new Country("Portugal", new BigDecimal("10196709"));
        Country unitedKingdom = new Country("United Kingdom", new BigDecimal("67886011"));
        Country spain = new Country("Spain", new BigDecimal("47100396"));
        // 163 029 727

        //Asia
        Country china = new Country("China", new BigDecimal("1439323776"));
        Country india = new Country("India", new BigDecimal("1380004385"));
        Country japan = new Country("Japan", new BigDecimal("126476461"));
        Country thailand = new Country("Thailand", new BigDecimal("69799978"));
        // 3 015 604 600

        //North America
        Country usa = new Country("United States", new BigDecimal("329702896"));
        Country canada = new Country("Canada", new BigDecimal("37742154"));
        Country cuba = new Country("Cuba", new BigDecimal("11326616"));
        Country mexico = new Country("Mexico", new BigDecimal("128932753"));
        //507 704 419
        // All continents: 3 686 338 746

        //When
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        europe.addCountry(poland);
        europe.addCountry(portugal);
        europe.addCountry(unitedKingdom);
        europe.addCountry(spain);

        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(japan);
        asia.addCountry(thailand);

        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(cuba);
        northAmerica.addCountry(mexico);

        BigDecimal expectedPeopleQuantity = new BigDecimal("3686338746");
        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(expectedPeopleQuantity, worldPeopleQuantity);

    }
}
