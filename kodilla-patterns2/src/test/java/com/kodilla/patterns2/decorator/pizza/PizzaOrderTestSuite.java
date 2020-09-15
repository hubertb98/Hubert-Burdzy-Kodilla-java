package com.kodilla.patterns2.decorator.pizza;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese", description);
    }

    @Test
    public void testBasicPizzaWithMushroomsGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new MushroomsPizzaDecorator(pizza);

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(17), theCost);

    }

    @Test
    public void testBasicPizzaWithMushroomsGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new MushroomsPizzaDecorator(pizza);

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese, mushrooms", description);
    }

    @Test
    public void testBasicPizzaWithMushroomsWithOnionGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new MushroomsPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(19), theCost);
    }

    @Test
    public void testBasicPizzaWithMushroomsWithOnionGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new MushroomsPizzaDecorator(pizza);
        pizza = new OnionPizzaDecorator(pizza);

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese, mushrooms, onion", description);
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndBaconGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ExtraCheesePizzaDecorator(pizza);
        pizza = new BaconPizzaDecorator(pizza);

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(22), theCost);
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndBaconGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ExtraCheesePizzaDecorator(pizza);
        pizza = new BaconPizzaDecorator(pizza);

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese, extra cheese, bacon", description);
    }

    @Test
    public void testBasicPizzaOrderWithOnionAndBaconAndJalapenosGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new BaconPizzaDecorator(pizza);
        pizza = new JalapenosPizzaDecorator(pizza);

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(24), theCost);
    }

    @Test
    public void testBasicPizzaOrderWithOnionAndBaconAndJalapenosGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new OnionPizzaDecorator(pizza);
        pizza = new BaconPizzaDecorator(pizza);
        pizza = new JalapenosPizzaDecorator(pizza);

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese, onion, bacon, jalapenos", description);
    }

    @Test
    public void testBasicPizzaOrderWithBaconGetCost() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new BaconPizzaDecorator(pizza);

        BigDecimal theCost = pizza.getCost();

        assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    public void testBasicPizzaOrderWithBaconGetDescription() {
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new BaconPizzaDecorator(pizza);

        String description = pizza.getDescription();

        assertEquals("Pizza with tomato souse and cheese, bacon", description);
    }
}