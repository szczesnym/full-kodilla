package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LibrariesAdapter {
    private Statistics libraryBStatistics;

    public LibrariesAdapter() {
        this.libraryBStatistics = new Statistics();
    }

    public int medianPublicationYear(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> books) {

        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> tempMapOfBBooks = new HashMap<>();

        for (com.kodilla.patterns2.adapter.bookclasifier.librarya.Book bookFromSet : books) {
            com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book bookFromB = new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                    bookFromSet.getAuthor(),
                    bookFromSet.getTitle(),
                    bookFromSet.getPublicationYear()
            );
            BookSignature bookSignature = new BookSignature(bookFromSet.getSignature());
            tempMapOfBBooks.put(bookSignature, bookFromB);
        }
        return libraryBStatistics.medianPublicationYear(tempMapOfBBooks);
    }
}
