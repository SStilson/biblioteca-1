package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws IOException {
        Collection<Book> bookList = new ArrayList<Book>();
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        Integer bookNumber = 1;
        bookList.add(new Book(printStream, "Book one", "author", "year", bookNumber));

        QuitCommand quitCommand = new QuitCommand(printStream);
        Library library =  new Library(bookList, printStream);
        CheckoutMenu checkoutMenu = new CheckoutMenu(printStream, bufferedReader, library) ;
        Command[] commands = {new PrintBooksCommand(library), new CheckoutBookCommand(library, bookNumber, checkoutMenu), quitCommand};

        Menu menu = new Menu(printStream, bufferedReader, quitCommand, commands);

        new Application(printStream, menu).start();
    }

}
