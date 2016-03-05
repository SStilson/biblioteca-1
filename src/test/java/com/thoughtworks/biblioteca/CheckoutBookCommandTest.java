package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    @Test
    public void shouldStartCheckoutProcess() {
        Library library = mock(Library.class);
        Integer bookNumber = 1;
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(library, bookNumber);

        checkoutBookCommand.execute();

        verify(library).checkoutBook(bookNumber);
    }

}