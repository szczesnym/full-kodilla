package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import com.kodilla.patterns2.adapter.bookclassifier.LibrariesAdapter;

import java.util.Arrays;
import java.util.Set;

public class BookClassifier implements Classifier {
    private LibrariesAdapter adapterToLibraryB;


    public BookClassifier() {
        adapterToLibraryB = new LibrariesAdapter();
    }

    public int publicationYearMedian(Set<Book> bookSet) {
        if (bookSet.size() == 0) {
            return 0;
        }
        int[] years = new int[bookSet.size()];
        int n = 0;
        for (Book bookFromSet : bookSet) {
            years[n] = bookFromSet.getPublicationYear();
            n++;
        }
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int) (years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }
}
