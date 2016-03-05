package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.LessThan;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private Library library;
    private Collection<Book> books;
    private Book book;
    private Book book2;

    @Before
    public void setUp(){
        books = new ArrayList<Book>();
        library = new Library(books);

        book = mock(Book.class);
        book2 = mock(Book.class);
    }

    @Test
    public void shouldPrintABook(){
        books.add(book);
        library.printBooks();
        verify(book).printBookDetails();
    }

    @Test
    public void shouldPrintTwoBooksWhenGivenTwoBooks(){
        books.add(book);
        books.add(book2);

        library.printBooks();

        verify(book2).printBookDetails();
    }

    @Test
    public void shouldRemoveABookWhenCheckoutIsRun() {
        books.add(book);
        books.add(book2);
        Integer bookListSize = books.size();

        when(book.getBookNumber()).thenReturn(1) ;
        when(book.matchesBookNumber(1)).thenReturn(true) ;

        library.checkoutBook(book.getBookNumber());

        assertTrue(books.size() < bookListSize) ;
    }
}