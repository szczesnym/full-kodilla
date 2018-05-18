package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    private void setBooks(Set<Book> setBooks) {
        this.books = setBooks;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library copyLibrary = this.shallowCopy();
        Set<Book> copyBooks = new HashSet<>();
        for(Book book:this.getBooks()) {
            copyBooks.add(book);
        }
        copyLibrary.setBooks(copyBooks);
        copyLibrary.setName("Copy:"+this.name);
    }
}