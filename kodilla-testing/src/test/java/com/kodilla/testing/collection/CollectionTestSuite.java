package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Integer> oddNumbersList = new ArrayList<>();
        oddNumbersList.add(1);
        oddNumbersList.add(3);
        oddNumbersList.add(14);
        oddNumbersList.add(10);
        oddNumbersList.add(32);
        oddNumbersList.add(39);
        oddNumbersList.add(26);
        oddNumbersList.add(17);
        oddNumbersList.add(43);
        oddNumbersList.add(19);

        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(39);
        expectedList.add(17);
        expectedList.add(43);
        expectedList.add(19);

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(oddNumbersList);

        //Then
        Assert.assertEquals(expectedList, resultList);

    }
}