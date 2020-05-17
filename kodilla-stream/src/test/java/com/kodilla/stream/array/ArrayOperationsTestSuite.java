package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {9, 15, 11, 17, 1, 12, 17, 11, 14, 6,
                2, 8, 2, 5, 19, 9, 10, 16, 20, 11};

        double expectedAverage = 10.75;

        //When
        double average = ArrayOperations.getAverage(numbers);


        //Then
        Assert.assertEquals(expectedAverage, average, 0);


    }
}
