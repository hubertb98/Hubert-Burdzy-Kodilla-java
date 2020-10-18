package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        Book book1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "Mickiewicz");
        Book book2 = new Book("Michal Szafranski", "Finansowy Ninja", 2019, "Szafranski");
        Book book3 = new Book("Radek Kotarski", "Wlam sie do mozgu", 2017, "Kotarski");

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);

        int bookMedian = medianAdapter.publicationYearMedian(bookSet);

        System.out.println(bookMedian);
        assertEquals(bookMedian, 2017);
    }
}