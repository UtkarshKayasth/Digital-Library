# Digital Library Book Management System

## Project Overview
The Digital Library Book Management System is a Java-based console application designed to help librarians efficiently manage books in a library. The system allows users to add, update, search, and delete books while maintaining their availability status.

## Features
- **Add a Book**: Add a new book with details like ID, Title, Author, Genre, and Availability Status.
- **View All Books**: Display a list of all books with their details.
- **Search for a Book**: Search for a book by its ID or Title.
- **Update Book Details**: Modify book details such as Title, Author, Genre, or Availability Status.
- **Delete a Book**: Remove a book from the catalog using its ID.
- **Exit the System**: Close the application.

## Setup and Run Instructions
### Prerequisites
- Java 14 or higher installed on your system.
- Maven 3.6 or higher installed.

### Steps to Run the Application
1. Clone the repository or download the project files.
2. Navigate to the project directory:
   ```bash
   cd DigitalLibrary
3. Compile the project using Maven :
   mvn compile
4. Run the application :
   java -cp target/classes library.ui.LibraryApp

   Running Tests:
   To run the unit tests, use the following command:
   mvn test
   
##Running the JAR File

After building the project, you can run it as a JAR file:

Build the JAR file using Maven:
mvn package

Navigate to the project directory and run:
project directory - cd C:\Users\Win10\DigitalLibrary
run - java -jar DigitalLibrary-1.0-SNAPSHOT.jar

Example Output:
Welcome to the Digital Library System

1) Add Book  
2) View Books  
3) Search Book  
4) Update Book  
5) Delete Book  
6) Exit  
Choose an option:

Challenges Faced:
1. Handling Edge Cases:

-Ensuring that duplicate Book IDs are not allowed.
-Validating non-empty Title and Author fields.
-Restricting Availability Status to "Available" or "Checked Out."

2. Designing a Modular System:

-Separating business logic (LibraryService) from user interaction (LibraryApp).
-Ensuring the system is scalable for future enhancements.

3. Error Handling:

-Implementing custom exceptions (InvalidBookOperationException) for better error reporting.


Improvements for the Future:

1. Persistence:
-Add a database or file-based storage to save books permanently.

2. Enhanced Search:
-Implement partial matching for Title searches.

3. User Interface:
-Replace the console-based UI with a graphical user interface (GUI) or a web-based interface.

4. Additional Features:
-Add support for managing multiple users or borrowing/returning books.

Directory Structure:
DigitalLibrary/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── library/
│   │   │   │   ├── ui/
│   │   │   │   │   └── LibraryApp.java
│   │   │   │   ├── models/
│   │   │   │   │   └── Book.java
│   │   │   │   ├── services/
│   │   │   │   │   └── LibraryService.java
│   │   │   │   ├── exceptions/
│   │   │   │   │   └── InvalidBookOperationException.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── library/
│   │   │   │   ├── tests/
│   │   │   │   │   ├── LibraryServiceTest.java
                    ├── LibraryServiceUnitTest.java


Author:
UTKARSH KAYASTH
Email: utkarshkayasth485@gmail.com
