package library.tests;

import library.models.Book;
import library.services.LibraryService;

public class LibraryServiceTest {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        // Test adding books
        System.out.println("=== Adding Books ===");
        libraryService.addBook(new Book("1", "Book One", "Author One", "Fiction", "Available"));
        libraryService.addBook(new Book("2", "Book Two", "Author Two", "Non-Fiction", "Checked Out"));
        libraryService.addBook(new Book("1", "Duplicate ID", "Author Three", "Fiction", "Available")); // Duplicate ID
        libraryService.addBook(new Book("3", "", "Author Four", "Fiction", "Available")); // Empty title
        libraryService.addBook(new Book("4", "Book Four", "", "Fiction", "Available")); // Empty author
        libraryService.addBook(new Book("5", "Book Five", "Author Five", "Fiction", "Invalid Status")); // Invalid status

        // Test viewing books
        System.out.println("\n=== Viewing All Books ===");
        libraryService.viewBooks();

        // Test searching for a book
        System.out.println("\n=== Searching for Books ===");
        System.out.println(libraryService.searchBook("1")); // Search by ID
        System.out.println(libraryService.searchBook("Book Two")); // Search by title
        System.out.println(libraryService.searchBook("Nonexistent")); // Nonexistent book

        // Test updating a book
        System.out.println("\n=== Updating Books ===");
        libraryService.updateBook("1", "Updated Book One", "Updated Author One", "Updated Genre", "Checked Out");
        libraryService.updateBook("6", "Nonexistent Book", "Author", "Genre", "Available"); // Nonexistent book
        libraryService.updateBook("2", "", "Updated Author Two", "Updated Genre", "Available"); // Empty title
        libraryService.updateBook("2", "Updated Book Two", "", "Updated Genre", "Available"); // Empty author
        libraryService.updateBook("2", "Updated Book Two", "Updated Author Two", "Updated Genre", "Invalid Status"); // Invalid status

        // Test viewing books after updates
        System.out.println("\n=== Viewing All Books After Updates ===");
        libraryService.viewBooks();

        // Test deleting a book
        System.out.println("\n=== Deleting Books ===");
        libraryService.deleteBook("1"); // Existing book
        libraryService.deleteBook("6"); // Nonexistent book

        // Test viewing books after deletion
        System.out.println("\n=== Viewing All Books After Deletion ===");
        libraryService.viewBooks();
    }
}