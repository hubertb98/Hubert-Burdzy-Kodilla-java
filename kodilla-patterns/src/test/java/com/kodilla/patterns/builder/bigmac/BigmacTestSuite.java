package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testNewBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("chili pepper")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals("barbecue", bigmac.getSauce());
        Assert.assertEquals("with sesame", bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
    }
}
