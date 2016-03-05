package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Book {
    private PrintStream printStream;
    private String title;
    private String author;
    private String year;
    private Integer bookNumber;

    public Book(PrintStream printStream, String title, String author, String year, Integer bookNumber) {
        this.printStream = printStream;
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookNumber = bookNumber;
    }

    public Boolean matchesBookNumber(Integer bookNumber) {
        return bookNumber.equals(this.getBookNumber());
    }

    public Integer getBookNumber() {
        return this.bookNumber;
    }

    public void printBookDetails(){

        printStream.println(String.format("%s | %s  |  %s  |  %s", bookNumber, title, author, year));
    }

}
