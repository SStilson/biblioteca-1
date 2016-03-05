package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private PrintBooksCommand printBooksCommand;
    private QuitCommand quitCommand;
    private CheckoutBookCommand checkoutBookCommand;

    @Before
    public void setUp() throws IOException {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        printBooksCommand = mock(PrintBooksCommand.class);
        checkoutBookCommand = mock(CheckoutBookCommand.class);
        quitCommand = mock(QuitCommand.class);

        Command[] commands = {printBooksCommand, checkoutBookCommand, quitCommand};

        menu = new Menu(printStream, bufferedReader, quitCommand, commands);
    }

    @Test
    public void shouldShowMenuOnStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.startMenu();
        verify(printStream).println(contains("Main Menu"));
        verify(printStream).println(contains("List Books"));
        verify(printStream).println(contains("Quit"));
        verify(printStream).println(contains("Checkout Book"));
        verify(printStream).println(contains("Return Book"));
    }

    @Test
    public void shouldRunPrintBooksCommandWhenInputIsOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.startMenu();
        verify(printBooksCommand).execute();
    }

    @Test
    public void shouldRunCheckoutBookCommandWhenInputIsTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "3");
        menu.startMenu();
        verify(checkoutBookCommand).execute();
    }

    @Test
    public void shouldRunQuitCommandWhenInputIsThree() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");
        menu.startMenu();
        verify(quitCommand).execute();
    }

    @Test
    public void shouldShowErrorMessageWhenNotGivenValidOptionSelection() throws IOException {
        when(bufferedReader.readLine()).thenReturn("asdf","1");
        menu.startMenu();
        verify(printStream).println(contains("Select a valid option!"));
    }
}