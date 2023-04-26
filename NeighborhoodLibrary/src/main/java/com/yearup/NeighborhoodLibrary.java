package com.yearup;

import java.util.Scanner;

import static java.lang.System.in;

public class NeighborhoodLibrary {
    private static Book[] books = new Book[5];


    private static int numBooks = 5;


    public static void main(String[] args) {



        books[0] = new Book(1, "9780", "Halo");
        books[1] = new Book(2, "9380", "Baby");
        books[2] = new Book(3, "4444", "Clay");
        books[3] = new Book(4, "8822", "Hate");
        books[4] = new Book(5, "2233", "Water");



        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Welcome to the Book Store!");
            System.out.println("Please choose an option:");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    showCheckedOutBooks(scanner);
                    break;
                case "3":
                    checkOutBook(scanner);
                    break;
                case "4":
                    checkInBook(scanner);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void checkOutBook(Scanner scanner) {
    }

    private static void checkInBook(Scanner scanner) {
    }
    public static void showAvailableBooks(Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.getIsCheckedOut()) {
                System.out.println(book);
            }
        }
        System.out.println("");

        System.out.println("Enter the ID of the book you want to check out or enter 'exit' to go back to the main menu:");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("exit")) {
            return;
        }

        int bookId = Integer.parseInt(userInput);
        Book selectedBook = null;
        for (Book book : books) {
            if (book.getId() == bookId) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Invalid book ID entered. Please try again.");
            return;
        }

        if (selectedBook.getIsCheckedOut()) {
            System.out.println("The book is already checked out.");
            return;
        }

        System.out.println("Enter your name:");
        String borrowerName = scanner.nextLine();

        selectedBook.checkOut(borrowerName);
        System.out.println("The book has been checked out. Enjoy your reading!");
    }


    /*public static void showAvailableBooks(Scanner scanner) {
        // Show available books
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.getIsCheckedOut()) {
                System.out.println(book);
            }
        }
        System.out.println("");
    }
*/
    public static void showCheckedOutBooks(Scanner scanner) {
        // Show checked out books
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.getIsCheckedOut()) {
                System.out.println(book + " - Checked out to " + book.getCheckedOutTo());
            }
        }
        System.out.println("");

        // Prompt user to check in a book or go back to the home screen
        while (true) {
            System.out.println("Enter the ID of the book you want to check in, or X to go back to the home screen:");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("x")) {
                break;
            }

            try {
                int bookId = Integer.parseInt(choice);
                Book book = null;

                for (Book b : books) {
                    if (b.getId() == bookId) {
                        book = b;
                        break;
                    }
                }

                if (book != null) {
                    book.checkIn();
                    System.out.println("Book with ID " + bookId + " has been checked in.");
                    break;
                } else {
                    System.out.println("Invalid book ID. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid book ID or X to go back to the home screen.");
            }
        }

        System.out.println("");
    }

   /* public static void checkOutBook(Scanner scanner) {
        // Prompt user to enter the ID of the book to check out
        System.out.println("Enter the ID of the book you want to check out, or X to go back to the home screen:");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("x")) {
            return;
        }

        try {
            int bookId = Integer.parseInt(choice);
            Book book = null;

            // Find the book with the given ID
            for (Book b : books) {
                if (b.getId() == bookId) {
                    book = b;
                    break;
                }
            }

            if (book != null && !book.isCheckedOut()) {
                // Prompt user to enter their name
                System.out.println("Enter your name to check out " + book.getTitle() + ":");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println(book.getTitle() + " has been checked out to " + name + ".");
            } else if (book != null && book.isCheckedOut()) {
                System.out.println(book.getTitle() + " is already checked out to " + book.getCheckedOutTo() + ".");
            } else {
                System.out.println("Invalid book ID. Please try again.");
            }
        } catch (NumberFormatException e) {


        }



    }
    */
    public static void checkoutBook(Scanner scanner) {
        System.out.println("Enter the ID of the book you want to check out:");
        int bookId = scanner.nextInt();

        boolean bookFound = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getId() == bookId && !books[i].getIsCheckedOut()) {
                books[i].checkOut();
                System.out.println("You have checked out " + books[i].getTitle() + ".");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("The book with ID " + bookId + " is not available for checkout.");
        }
    }
}