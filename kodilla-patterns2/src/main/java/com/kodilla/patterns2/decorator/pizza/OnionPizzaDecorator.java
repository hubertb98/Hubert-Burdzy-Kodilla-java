package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionPizzaDecorator extends AbstractPizzaOrderDecorator {

    public OnionPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", onion";
    }
}
