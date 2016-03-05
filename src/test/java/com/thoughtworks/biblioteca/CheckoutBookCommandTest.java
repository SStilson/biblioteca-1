package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookCommandTest {

    private Library library ;
    private Integer bookNumber ;
    CheckoutMenu checkoutMenu ;
    private CheckoutBookCommand checkoutBookCommand ;

    @Before
    public void setUp() {
        library = mock(Library.class);
        bookNumber = 1;
        checkoutMenu = mock(CheckoutMenu.class) ;
        checkoutBookCommand = new CheckoutBookCommand(library, bookNumber, checkoutMenu);
    }

    @Test
    public void shouldShowMenuWithOptionToSelectBookNumberWhenUserRequestsCheckOut() throws IOException {
        checkoutBookCommand.execute();
        verify(checkoutMenu).startMenu() ;
    }

}