package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutMenuTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Library library ;
    private CheckoutMenu checkoutMenu;
    private Book book;

    @Before
    public void setUp() throws IOException {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        book = mock(Book.class);

        checkoutMenu = new CheckoutMenu(printStream, bufferedReader, library);
    }

    @Test
    public void shouldShowMenuOnStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(library.getBookFromBookNumber(1)).thenReturn(book) ;
        when(library.hasBook(book)).thenReturn(true) ;

        checkoutMenu.startMenu();
        verify(printStream).println(contains("Please enter the number of the book you would like to check out:"));
    }

    @Test
    public void shouldTellLibraryToCheckoutBookWhenUserRequests() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(library.getBookFromBookNumber(1)).thenReturn(book) ;
        when(library.hasBook(book)).thenReturn(true) ;

        checkoutMenu.startMenu();

        verify(library).checkoutBook(1) ;
    }

    @Test
    public void shouldShowErrorMessageWhenBookIsNotAvailable() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1000", "1");

        when(library.getBookFromBookNumber(1000)).thenReturn(null) ;
        when(library.getBookFromBookNumber(1)).thenReturn(book) ;

        when(library.hasBook(null)).thenReturn(false) ;
        when(library.hasBook(book)).thenReturn(true) ;

        checkoutMenu.startMenu();
        verify(printStream).println(contains("That book is not available."));
    }



}