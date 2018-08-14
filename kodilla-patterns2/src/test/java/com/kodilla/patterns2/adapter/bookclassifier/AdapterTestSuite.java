package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import static  org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        Book testBook1 = new Book("Jonh Smith",
                "Title 1",
                2000,
                "SIG001");
        Book testBook2 = new Book("John Doe",
                "Title 2",
                2001,
                "SIG002");
        Book testBook3 = new Book("Jan Kowalski",
                "Title 3",
                1998,
                "SIG003");
        Book testBook4 = new Book("Tomasz Nowak",
                "Title 4",
                1950,
                "SIG004");
        Set<Book> testSetOfBooks = new HashSet<>();
        testSetOfBooks.add(testBook1);
        testSetOfBooks.add(testBook2);
        testSetOfBooks.add(testBook3);
        testSetOfBooks.add(testBook4);
        LibrariesAdapter librariesAdapter = new LibrariesAdapter();
        //When
        int testPublicationYearMedian = librariesAdapter.publicationYearMedian(testSetOfBooks);
        //Then
        assertEquals(2000, testPublicationYearMedian);

    }

}
