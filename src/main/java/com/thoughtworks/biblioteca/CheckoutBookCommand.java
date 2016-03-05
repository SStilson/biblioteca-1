package com.thoughtworks.biblioteca;

import java.io.IOException;

public class CheckoutBookCommand implements Command {
    private Library library;
    private Integer bookNumber;
    private CheckoutMenu checkoutMenu;

    public CheckoutBookCommand(Library library, Integer bookNumber, CheckoutMenu checkoutMenu) {
        this.library = library;
        this.bookNumber = bookNumber;
        this.checkoutMenu = checkoutMenu;
    }

    @Override
    public void execute() throws IOException {
        checkoutMenu.startMenu();
    }
}
