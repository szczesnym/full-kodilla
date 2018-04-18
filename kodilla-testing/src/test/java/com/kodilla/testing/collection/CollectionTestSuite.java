package com.kodilla.testing.collection;

import org.junit.Assert;
import org.junit.*;
import java.lang.Integer;
import java.lang.System;
import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test List Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test List Case: end");
    }
    @Test
    public void testExterminateNullList() {
        //Given
        OddNumberExterminator sutExterminator = new OddNumberExterminator();
        //When
        ArrayList <Integer> resultArrayList = sutExterminator.exterminate(null);
        //Then
        Assert.assertNull(resultArrayList);
    }
    @Test
    public void testExterminateEmptyList() {
        //Given
        ArrayList <Integer> sutArrayList = new ArrayList<>();
        OddNumberExterminator sutExterminator = new OddNumberExterminator();
        //When
        ArrayList <Integer> resultArrayList = sutExterminator.exterminate(sutArrayList);
        //Then
        Assert.assertTrue(resultArrayList.isEmpty());
    }
    @Test
    public void testExterminateNotEmptyList() {
        //Given
        OddNumberExterminator sutExterminator = new OddNumberExterminator();
        //When
        ArrayList <Integer> testArrayList = sutExterminator.exterminate( new ArrayList(Arrays.asList(0 , 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        //Then
        Assert.assertTrue(testArrayList.equals(new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8))));
    }
}
