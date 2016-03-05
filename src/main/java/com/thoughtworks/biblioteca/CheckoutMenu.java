package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class CheckoutMenu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Library library;

    public CheckoutMenu(PrintStream printStream, BufferedReader bufferedReader, Library library) {
        this.printStream = printStream ;
        this.bufferedReader = bufferedReader ;
        this.library = library ;
    }

    public void startMenu() throws IOException {
        showMenu();
        chooseOption();
    }

    private void showMenu() {
       printStream.println("Please enter the number of the book you would like to check out:");
    }

    private void chooseOption() throws IOException {
        String input = getValidBookNumberFromUser();
        Integer requestedBookNumber = Integer.parseInt(input);
        library.checkoutBook(requestedBookNumber) ;
    }

    private String getValidBookNumberFromUser() throws IOException {
        String input = bufferedReader.readLine();
        Book book = library.getBookFromBookNumber(Integer.parseInt(input)) ;
        while(!library.hasBook(book)) {
            printStream.println("That book is not available.");
            input = bufferedReader.readLine();
            book = library.getBookFromBookNumber(Integer.parseInt(input)) ;
        }
        return input;

    }
}
