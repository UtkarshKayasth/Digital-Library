package library.ui;

import java.util.Scanner;

import library.models.Book;
import library.services.LibraryService;

public class LibraryApp {

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("📖 Welcome to the Digital Library System");

        while (true) {
            System.out.println("\n1️⃣ Add Book  2️⃣ View Books  3️⃣ Search Book  4️⃣ Update Book  5️⃣ Delete Book  6️⃣ Exit");
            System.out.print("➡️ Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("📘 Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("📗 Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("📕 Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("📙 Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("📖 Enter Availability (Available/Checked Out): ");
                    String status = scanner.nextLine();

                    try {
                        libraryService.addBook(new Book(id, title, author, genre, status));
                        System.out.println("✅ Book added successfully!");
                    } catch (Exception e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("\n📚 All Books:");
                    libraryService.viewBooks();
                }
                case 3 -> {
                    System.out.print("🔍 Enter Book ID or Title: ");
                    String query = scanner.nextLine();
                    Book book = libraryService.searchBook(query);
                    if (book != null) {
                        System.out.println("✅ Book Found: " + book);
                    } else {
                        System.out.println("⚠️ Book not found!");
                    }
                }
                case 4 -> {
                    System.out.print("✏️ Enter Book ID to Update: ");
                    String id = scanner.nextLine();
                    System.out.print("📗 Enter New Title: ");
                    String title = scanner.nextLine();
                    System.out.print("📕 Enter New Author: ");
                    String author = scanner.nextLine();
                    System.out.print("📙 Enter New Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("📖 Enter New Availability (Available/Checked Out): ");
                    String status = scanner.nextLine();

                    try {
                        libraryService.updateBook(id, title, author, genre, status);
                        System.out.println("✅ Book updated successfully!");
                    } catch (Exception e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("🗑️ Enter Book ID to Delete: ");
                    String id = scanner.nextLine();

                    try {
                        libraryService.deleteBook(id);
                        System.out.println("✅ Book deleted successfully!");
                    } catch (Exception e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("👋 Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default ->
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }
}
