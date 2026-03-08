package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Library}.
 * Following naming conventions: ClassName + Test
 */
class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void shouldAddNewBookSuccessfully() {
        // Given
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");

        // When
        boolean result = library.addBook(book);

        // Then
        assertTrue(result, "The book should be added successfully");
    }

    @Test
    void shouldIncreaseBookCountWhenAddingExistingBook() {
        // Given
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        library.addBook(book);

        // When
        boolean result = library.addBook(book);

        // Then
        assertTrue(result, "Adding an existing book should increase its count");
    }

    @Test
    void shouldAddUserSuccessfully() {
        // Given
        User user = new User("U001", "John Doe", "john@example.com");

        // When
        boolean result = library.addUser(user);

        // Then
        assertTrue(result, "The user should be added successfully");
    }

    @Test
    void shouldCreateLoanWhenBookIsAvailable() {
        // Given
        User user = new User("U001", "John Doe", "john@example.com");
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        library.addUser(user);
        library.addBook(book);

        // When
        Loan loan = library.loanABook("U001", "978-0134685991");

        // Then
        assertNotNull(loan, "A loan should be created when book is available");
    }

    @Test
    void shouldReturnNullWhenBookIsNotAvailable() {
        // Given
        User user = new User("U001", "John Doe", "john@example.com");
        library.addUser(user);

        // When
        Loan loan = library.loanABook("U001", "978-0134685991");

        // Then
        assertNull(loan, "Loan should be null when book is not available");
    }

    @Test
    void shouldReturnNullWhenUserDoesNotExist() {
        // Given
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        library.addBook(book);

        // When
        Loan loan = library.loanABook("U999", "978-0134685991");

        // Then
        assertNull(loan, "Loan should be null when user does not exist");
    }

    @Test
    void shouldReturnLoanSuccessfully() {
        // Given
        User user = new User("U001", "John Doe", "john@example.com");
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        library.addUser(user);
        library.addBook(book);
        Loan loan = library.loanABook("U001", "978-0134685991");

        // When
        Loan returnedLoan = library.returnLoan(loan);

        // Then
        assertNotNull(returnedLoan, "The loan should be returned successfully");
    }
}
