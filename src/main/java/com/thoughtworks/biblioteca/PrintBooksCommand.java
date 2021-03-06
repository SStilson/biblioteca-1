package com.thoughtworks.biblioteca;

public class PrintBooksCommand implements Command {
    private Library library;

    public PrintBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.printBooks();
    }
}
