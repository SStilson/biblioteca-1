package com.thoughtworks.biblioteca;

public class CheckoutBookCommand implements Command {
    private Library library;
    private Integer bookNumber;

    public CheckoutBookCommand(Library library, Integer bookNumber) {
        this.library = library;
        this.bookNumber = bookNumber;
    }

    @Override
    public void execute() {
        library.checkoutBook(bookNumber);
    }
}
