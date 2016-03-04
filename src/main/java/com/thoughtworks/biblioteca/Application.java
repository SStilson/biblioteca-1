package com.thoughtworks.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

public class Application {


    private PrintStream printStream;
    private Menu menu;

    public Application(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!\n");
        while (!menu.shouldQuitGetter()) {
            menu.startMenu();
        }
    }
}
