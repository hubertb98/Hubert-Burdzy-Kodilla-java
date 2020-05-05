package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {
    private static OddNumbersExterminator oddNumbersExterminator;

    @Before
    public void before() {
        System.out.println("Start the test");
    }

    @After
    public void after() {
        System.out.println("\nEnd of test");
    }
    @BeforeClass
    public static void beforeClass() {
        oddNumbersExterminator = new OddNumbersExterminator();
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<>();

        //When
        System.out.println("Testing empty list.");
        ArrayList<Integer> expectedList = oddNumbersExterminator.exterminate(emptyList);

        //Then
        Assert.assertEquals(expectedList.size(), emptyList.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        Random random = new Random();
        ArrayList<Integer> oddNumbersList = new ArrayList<>();

        //When
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(50 + 1);
            oddNumbersList.add(number);

        }
        ArrayList<Integer> expectedList = oddNumbersExterminator.exterminate(oddNumbersList);

        //Then
        Assert.assertEquals(expectedList, oddNumbersList);

    }
}