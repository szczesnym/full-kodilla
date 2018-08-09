package com.kodilla.patterns2.decorator.taxiportal;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuit {
    TaxiOrder theOrder ;
    @Before
    public void init() {
        theOrder = new BasicTaxiOrder();
    }

    @Test
    public void  testBasicTaxiOrderGetCost() {
        //Given


        //When
        BigDecimal orderCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(5), orderCost);

    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given

        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course", theDescription );

    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", theDescription);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //Given
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", theDescription);

    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(57), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network + child seat variant VIP express service", theDescription);

    }

}
