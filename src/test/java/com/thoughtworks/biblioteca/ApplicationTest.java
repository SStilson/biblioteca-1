package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationTest {

    private PrintStream printStream;
    private Application application;
    private Library library;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        menu = mock(Menu.class);

        when(menu.shouldQuitGetter()).thenReturn(false, true);
        application = new Application(printStream, menu);
        application.start();
    }

    @Test
    public void shouldPrintWelcomeMessageOnProgramStart(){
        verify(printStream).println(contains("Welcome to Biblioteca!"));
    }

    @Test
    public void shouldTellMenuToDisplay() throws IOException {
        verify(menu).startMenu();
    }

}