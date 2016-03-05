package com.thoughtworks.biblioteca;


import java.util.Collection;

public class Library {
    private Collection<Book> books;

    public Library(Collection<Book> books) {

        this.books = books;
    }

    public void checkoutBook(Integer bookNumber) {
        Book bookToRemove = null ;
        for(Book book: books) {
            if(book.matchesBookNumber(bookNumber)) {
                //books.remove(book);
                bookToRemove = book ;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }

    public void printBooks() {
        for(Book book : books){
            book.printBookDetails();
        }
    }
}
