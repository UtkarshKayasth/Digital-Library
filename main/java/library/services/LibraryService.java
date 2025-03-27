package library.services;

import java.util.HashMap;
import java.util.Map;

import library.exceptions.InvalidBookOperationException;
import library.models.Book;

public class LibraryService {

    private final Map<String, Book> books = new HashMap<>(); // Make books final

    public void addBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new InvalidBookOperationException("Title cannot be empty!");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new InvalidBookOperationException("Author cannot be empty!");
        }
        if (!isValidStatus(book.getStatus())) {
            throw new InvalidBookOperationException("Status must be 'Available' or 'Checked Out'!");
        }
        if (books.containsKey(book.getId())) {
            throw new InvalidBookOperationException("Book ID must be unique!");
        }
        books.put(book.getId(), book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.values().forEach(System.out::println);
        }
    }

    public Book searchBook(String query) {
        return books.values().stream()
                .filter(book -> book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }

    public void updateBook(String id, String title, String author, String genre, String status) {
        Book book = books.get(id);
        if (book == null) {
            throw new InvalidBookOperationException("Book not found!");
        }
        if (title != null && !title.trim().isEmpty()) {
            book.setTitle(title);
        }
        if (author != null && !author.trim().isEmpty()) {
            book.setAuthor(author);
        }
        if (genre != null) {
            book.setGenre(genre);
        }
        if (isValidStatus(status)) {
            book.setStatus(status);
        } else {
            throw new InvalidBookOperationException("Status must be 'Available' or 'Checked Out'!");
        }
    }

    public void deleteBook(String id) {
        if (!books.containsKey(id)) {
            throw new InvalidBookOperationException("Book not found!");
        }
        books.remove(id);
    }

    private boolean isValidStatus(String status) {
        return "Available".equalsIgnoreCase(status) || "Checked Out".equalsIgnoreCase(status);
    }
}
