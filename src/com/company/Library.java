package com.company;

import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    String address;
    ArrayList<Book> books = new ArrayList<>();

    public Library(String address) {
        this.address = address;
    }
    // Method to add books to library inventory
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to print the library hours of operation
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    // Method to print the address of the library
    public void printAddress() {
        System.out.println(address);
    }

    // Method to determine if book can be borrowed.
    public void borrowBook(String bookToBorrow) {
        // create statement variable which is what will be printed to the console.
        String statement = "";

        /*
        Create an if statement to determine if the library has any books.
        If the library does have books, loop through the inventory to determine the following:
            1. Does the library have the book requested?
            2. Is the book requested in stock or checked out?
        This loop will determine the appropriate statement to print out to the customer.
         */

        if (books.size() == 0) {
            statement = "Sorry, this book is not in our catalog.";
        } else {
            for (Book book : books) {
                if (book.getTitle().equals(bookToBorrow) && !book.isBorrowed()) {
                    statement = "You successfully borrowed " + book.getTitle();
                    book.borrowed();
                } else if (book.getTitle().equals(bookToBorrow) && book.isBorrowed()) {
                    statement = "Sorry, this book is already borrowed.";
                } else {
                    statement = "Sorry, this book is not in our catalog.";
                }
            }
        }
        System.out.println(statement);
    }

    // Method to print out available books in library inventory
    public void printAvailableBooks() {

        if (books.size() > 0) {
            for (Book book : books) {
                if (!book.isBorrowed()) {
                    System.out.println(book.getTitle());
                }
            }
        } else {
            System.out.println("No books in this catalog ");
        }
    }


    public void returnBook(String bookToReturn) {

        String statement = "";

        for (Book book : books) {
            if (book.getTitle().equals(bookToReturn) && book.isBorrowed()) {
                statement = "You successfully returned " + book.getTitle();
                book.returned();
            } else if (book.getTitle().equals(bookToReturn) && !book.isBorrowed()) {
                statement = "Sorry, this book must be from another library. We have this book in stock.";
            } else {
                statement = "Sorry, this book is not in our catalog.";
            }
        }
        System.out.println(statement);
    }



    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
