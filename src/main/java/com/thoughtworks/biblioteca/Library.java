package com.thoughtworks.biblioteca;


import java.io.PrintStream;
import java.util.Collection;

public class Library {
    private Collection<Book> books;
    private PrintStream printStream;

    public Library(Collection<Book> books, PrintStream printStream) {

        this.books = books;
        this.printStream = printStream;
    }

    public void checkoutBook(Integer bookNumber) {
        Book bookToRemove = null ;
        for(Book book: books) {
            if(book.matchesBookNumber(bookNumber)) {
                bookToRemove = book ;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            printStream.println("Thank you! Enjoy the book");
        }
    }

    public void printBooks() {
        if (books.isEmpty()) {
            printStream.println("Sorry, there are no books available");
        } else {
            for(Book book : books){
                book.printBookDetails();
            }
        }
    }
}
