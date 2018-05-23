package com.kodilla.patterns.singleton.prototype.library;

import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    Library sutLibrary;

    @Before
    public void initialize() {
        sutLibrary = new Library("sutLibrary");
        Book sutBook1 = new Book("Title1", "John Doe", LocalDate.of(2018, 1, 1));
        Book sutBook2 = new Book("Title2", "John Smith", LocalDate.of(2013, 2, 18));
        sutLibrary.addBookToLibrary(sutBook1);
        sutLibrary.addBookToLibrary(sutBook2);
    }

    @Test
    public void testGetBooks() throws CloneNotSupportedException {
        //Given
        Book sutCopyBook = new Book("COPY Book", "Tom John", LocalDate.of(2011, 4, 12));
        Book sutCopyBook2 = new Book("COPY 2 Book", "Tom John", LocalDate.of(2011, 4, 12));
        Library sutShallowCopyLibrary = sutLibrary.shallowCopy();
        Library sutDeepCopyLibrary = sutLibrary.deepCopy();
        //When
        sutShallowCopyLibrary.addBookToLibrary(sutCopyBook);
        sutDeepCopyLibrary.addBookToLibrary(sutCopyBook2);

        //Then
        Assert.assertEquals(sutLibrary.getBooks(), sutShallowCopyLibrary.getBooks());
        Assert.assertNotEquals(sutLibrary.getBooks(), sutDeepCopyLibrary.getBooks());
    }

    @Test
    public void testGetName() {
        //Given
        //When
        String sutLibraryName = sutLibrary.getName();
        //Then
        Assert.assertEquals("sutLibrary", sutLibraryName);
    }
}
