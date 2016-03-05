package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private PrintStream printStream;
    private Book book;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        book = new Book(printStream, "Book 1", "Author 1", "Year 1", 1);
    }

    @Test
    public void shouldPrintBookTitle(){
        book.printBookDetails();
        verify(printStream).println(contains("Book 1"));
    }
    
    @Test
    public void shouldPrintBookAuthor(){
        book.printBookDetails();
        verify(printStream).println(contains("Author 1"));
    }

    @Test
    public void shouldPrintBookYear(){
        book.printBookDetails();
        verify(printStream).println(contains("Year 1"));
    }

}