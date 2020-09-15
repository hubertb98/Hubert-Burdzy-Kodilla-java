package com.kodilla.patterns2.decorator.taxiportal;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();

        BigDecimal calculatedCost = taxiOrder.getCost();

        assertEquals(new BigDecimal(5.00), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();

        String description = taxiOrder.getDescription();

        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);

        BigDecimal theCost = taxiOrder.getCost();

        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);

        String description = taxiOrder.getDescription();

        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        String description = taxiOrder.getDescription();

        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        BigDecimal theCost = taxiOrder.getCost();

        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        String description = taxiOrder.getDescription();

        assertEquals("Drive a course by MyTaxi Network + child seat + child seat", description);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        BigDecimal theCost = taxiOrder.getCost();

        assertEquals(new BigDecimal(39), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        System.out.println(taxiOrder.getCost());

        BigDecimal theCost = taxiOrder.getCost();

        assertEquals(new BigDecimal(52), theCost);

    }

    @Test
    public void testVipTaxiWithChildSeatGetDescription() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        System.out.println(taxiOrder.getDescription());

        String description = taxiOrder.getDescription();

        assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }
}
