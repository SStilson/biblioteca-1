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
        Integer requestedBookNumber = Integer.parseInt(bufferedReader.readLine());
        library.checkoutBook(requestedBookNumber) ;
    }

}
