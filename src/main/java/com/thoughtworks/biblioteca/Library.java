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

    public void checkoutBook(Book book) {
        if (book != null) {
            books.remove(book);
            printStream.println("Thank you! Enjoy the book");
        }
    }

    public void returnBook(Book book) {
        books.add(book);
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

    public boolean hasBook(Book book) {
        if (books.contains(book)) {
            return true;
        }  else return false;
    }

    public Book getBookFromBookNumber(Integer bookNumber) {
        Book matchingBook = null ;
        for(Book book: books) {
            if(book.matchesBookNumber(bookNumber)) {
                matchingBook = book ;
            }
        }
        return matchingBook ;
    }
}
