package library.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import library.exceptions.InvalidBookOperationException;
import library.models.Book;
import library.services.LibraryService;

@SuppressWarnings("unused")
class LibraryServiceUnitTest {

    @Test
    void testAddBook() {
        LibraryService libraryService = new LibraryService();
        Book book = new Book("1", "Book One", "Author One", "Fiction", "Available");

        libraryService.addBook(book);
        assertNotNull(libraryService.searchBook("1"));
    }

    @Test
    void testAddBookWithDuplicateId() {
        LibraryService libraryService = new LibraryService();
        Book book1 = new Book("1", "Book One", "Author One", "Fiction", "Available");
        Book book2 = new Book("1", "Duplicate Book", "Author Two", "Non-Fiction", "Checked Out");

        libraryService.addBook(book1);
        Exception exception = assertThrows(InvalidBookOperationException.class, () -> libraryService.addBook(book2));
        assertEquals("Book ID must be unique!", exception.getMessage());
    }

    @Test
    void testSearchNonExistentBook() {
        LibraryService libraryService = new LibraryService();

        assertNull(libraryService.searchBook("999")); // Non-existent ID
        assertNull(libraryService.searchBook("Nonexistent Title")); // Non-existent title
    }

    @Test
    void testViewBooksWhenEmpty() {
        LibraryService libraryService = new LibraryService();

        assertTrue(libraryService.searchBook("1") == null); // No books added yet
    }

    @Test
    void testAddBookWithInvalidInputs() {
        LibraryService libraryService = new LibraryService();

        // Empty title
        Exception exception1 = assertThrows(InvalidBookOperationException.class, ()
                -> libraryService.addBook(new Book("1", "", "Author One", "Fiction", "Available"))
        );
        assertEquals("Title cannot be empty!", exception1.getMessage());

        // Empty author
        Exception exception2 = assertThrows(InvalidBookOperationException.class, ()
                -> libraryService.addBook(new Book("2", "Book Two", "", "Fiction", "Available"))
        );
        assertEquals("Author cannot be empty!", exception2.getMessage());

        // Invalid status
        Exception exception3 = assertThrows(InvalidBookOperationException.class, ()
                -> libraryService.addBook(new Book("3", "Book Three", "Author Three", "Fiction", "Invalid Status"))
        );
        assertEquals("Status must be 'Available' or 'Checked Out'!", exception3.getMessage());
    }
}
