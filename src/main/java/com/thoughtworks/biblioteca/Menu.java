package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    protected PrintStream printStream;
    protected BufferedReader bufferedReader;
    private QuitCommand quitCommand;
    private Map<String, Command> menuOptionDispatch;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, QuitCommand quitCommand, Command[] commands) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.quitCommand = quitCommand;

        createCommandDispatch(commands);
    }

    private void createCommandDispatch(Command[] commands) {
        menuOptionDispatch = new HashMap<String, Command>();
        for(int i=0; i<commands.length; i++){
            String key = String.valueOf(i + 1);
            menuOptionDispatch.put(key, commands[i]);
        }
    }

    public boolean hasBeenToldToQuit() {
        return quitCommand.getShouldQuit();
    }

    public void startMenu() throws IOException {
        this.showMenu();
        this.chooseOption();
    }

    private void showMenu() {
        printStream.println(
                "Main Menu\n" +
                "Options (choose one):");

        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
        printStream.println("3. Quit");
    }

    private void chooseOption() throws IOException {

        String input = getValidInput();
        menuOptionDispatch.get(input).execute();
    }

    private String getValidInput() throws IOException {
        String input = bufferedReader.readLine();

        while (!menuOptionDispatch.containsKey(input)) {
            printStream.println("Select a valid option!");
            input = bufferedReader.readLine();
        }

        return input;
    }

}
