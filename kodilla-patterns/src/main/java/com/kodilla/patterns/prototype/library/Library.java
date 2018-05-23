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

    public void addBookToLibrary(Book book) {
        books.add(book);
    }

    private void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library copyLibrary = this.shallowCopy();
        Set<Book> copyBooks = new HashSet<>();
        for (Book book : this.getBooks()) {
           Book copyBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
            //copyLibrary.addBookToLibrary(copyBook);
            copyBooks.add(copyBook);
        }
        copyLibrary.setBooks(copyBooks);
        copyLibrary.setName("Copy:" + this.name);
        return copyLibrary;
    }
}