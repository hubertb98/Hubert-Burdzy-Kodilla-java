package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library");

        Book book1 = new Book("Unknown title", "Anonymous",
                LocalDate.of(1998, 1, 13));
        Book book2 = new Book("Unknown title", "Anonymous",
                LocalDate.of(1994, 5, 10));
        Book book3 = new Book("Unknown title", "Anonymous",
                LocalDate.of(1996, 3, 1));
        Book book4 = new Book("Unknown title", "Anonymous",
                LocalDate.of(1991, 11, 15));
        Book book5 = new Book("Unknown title", "Anonymous",
                LocalDate.of(1985, 10, 20));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertNotEquals(deepClonedLibrary.getBooks().size(), library.getBooks().size());

    }
}
