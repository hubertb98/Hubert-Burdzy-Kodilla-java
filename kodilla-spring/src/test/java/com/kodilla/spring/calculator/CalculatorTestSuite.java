package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(4, 6);
        double subResult = calculator.sub(5, 3);
        double mulResult = calculator.mul(3, 4);
        double divResult = calculator.div(15, 3);
        //Then
        Assert.assertEquals(10, addResult, 0);
        Assert.assertEquals(2, subResult, 0);
        Assert.assertEquals(12, mulResult, 0);
        Assert.assertEquals(5, divResult, 0);
    }
}
