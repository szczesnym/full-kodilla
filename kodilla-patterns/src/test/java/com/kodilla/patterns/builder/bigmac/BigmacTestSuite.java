package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class BigmacTestSuite {
    @Test
    public void testBigMacBuilder() {
        //Given
        BigMac sutBigMac = new BigMac.BigMacBuilder()
                                .bun(BunEnum.Sezam)
                                .burgers(3)
                                .ingredients(IngredientsEnum.Chease)
                                .ingredients(IngredientsEnum.Bacon)
                                .ingredients(IngredientsEnum.Mushroom)
                                .build();
        //When
        BunEnum bun = sutBigMac.getBun();
        int burgers = sutBigMac.getBurgers();
        SauceEnum sauce = sutBigMac.getSauce();
        Set<IngredientsEnum> ingredients = sutBigMac.getIngredients();
        //Then
        Assert.assertEquals(BunEnum.Sezam, bun);
        Assert.assertEquals(3, burgers);
        Assert.assertEquals(SauceEnum.Standart, sauce);
        Assert.assertEquals(3, ingredients.size());
    }
}
