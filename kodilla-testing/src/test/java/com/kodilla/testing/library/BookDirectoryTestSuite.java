package com.kodilla.testing.library;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

public class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    public ArrayList<Book> generateArrayListOfNBooks(int noOfBooks) {
        ArrayList<Book> tempArrayListOfBooks = new ArrayList<>();
        if (noOfBooks > 0) {
            for (int i = 0; i < noOfBooks; i++) {
                tempArrayListOfBooks.add(new Book("Title" + i, "Author " + i, 1990 + i));
            }
            return tempArrayListOfBooks;
        } else {
            return null;
        }
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary BookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        // When
        List<Book> theListOfBooks = BookLibrary.listBooksWithCondition("Secret");
        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListOfBooksInHandsOfNoBooks() {
        //Given
        LibraryUser libraryUser = new LibraryUser("John", "Doe", "32312312");
        ArrayList<Book> listOfBooksNoBooks = new ArrayList<>();
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(listOfBooksNoBooks);
        BookLibrary sutBookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> sutListOfBooks = sutBookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(0, sutListOfBooks.size());
    }

    @Test
    public void testListOfBooksInHandsOfOneBook() {
        //Given
        LibraryUser sutLibraryUser = new LibraryUser("John", "Doe", "32312312");
        ArrayList<Book> sutListOfBooksOneBooks = generateArrayListOfNBooks(1);
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        when(libraryDatabaseMock.listBooksInHandsOf(sutLibraryUser)).thenReturn(sutListOfBooksOneBooks);
        BookLibrary sutBookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> sutListOfBooksOneBook = sutBookLibrary.listBooksInHandsOf(sutLibraryUser);
        //Then
        assertEquals(1, sutListOfBooksOneBook.size());
    }

    @Test
    public void testListOfBooksInHandsOfFiveBooks() {
        //Given
        LibraryUser sutLibraryUser = new LibraryUser("John", "Doe", "32312312");
        ArrayList<Book> sutListOfBooksFiveBooks = generateArrayListOfNBooks(5);
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary sutBookLibrary = new BookLibrary(libraryDatabaseMock);
        when(libraryDatabaseMock.listBooksInHandsOf(sutLibraryUser)).thenReturn(sutListOfBooksFiveBooks);
        //When
        List<Book> sutListOfBooksOneBook = sutBookLibrary.listBooksInHandsOf(sutLibraryUser);
        //Then
        assertEquals(5, sutListOfBooksOneBook.size());
    }
}
