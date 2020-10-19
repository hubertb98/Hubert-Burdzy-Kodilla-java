package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianWithTreeBooksTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        Book book1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "Mickiewicz");
        Book book2 = new Book("Michal Szafranski", "Finansowy Ninja", 2019, "Szafranski");
        Book book3 = new Book("Radek Kotarski", "Wlam sie do mozgu", 2017, "Kotarski");

        //When
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        int bookMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(bookMedian);
        assertEquals(2017, bookMedian);
    }

    @Test
    public void publicationYearMedianWithTenBooksTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        Book book1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "Mickiewicz");
        Book book2 = new Book("Michal Szafranski", "Finansowy Ninja", 2019, "Szafranski");
        Book book3 = new Book("Radek Kotarski", "Wlam sie do mozgu", 2017, "Kotarski");
        Book book4 = new Book("Kevin Mitnick", "Duch w sieci", 2011, "Mitnick");
        Book book5 = new Book("Jordan Ellenberg", "Jak sie nie pomylic, czyli potega matematycznego myślenia", 2017, "Ellenberg");
        Book book6 = new Book("Kevin Mitnick", "Sztuka podstepu. Lamalem ludzi, nie hasla", 2010, "Mitnick");
        Book book7 = new Book("Cay S. Horstmann", "Java. Podstawy", 2019, "Horstmann");
        Book book8 = new Book("Andrew Hunt", "Pragmatyczny programista.", 2011, "Hunt");
        Book book9 = new Book("Radoslaw Sokol", "Testowanie aplikacji Java za pomoca JUnit", 2018, "Sokol");
        Book book10 = new Book("Tim Ferris", "Narzedzia tytanow", 2017, "Ferris");

        //When
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);
        bookSet.add(book7);
        bookSet.add(book8);
        bookSet.add(book9);
        bookSet.add(book10);
        int bookMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(bookMedian);
        assertEquals(2017, bookMedian);
    }

    @Test
    public void publicationYearMedianWithOneBookTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        Book book1 = new Book("Michal Szafranski", "Finansowy Ninja", 2019, "Szafranski");

        //When
        bookSet.add(book1);
        int bookMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(bookMedian);
        assertEquals(2019, bookMedian);

    }
}