package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        this.users = new ArrayList<>();
        this.books = new HashMap<>();
        this.loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.dosw.tdd.library.book.Book} into the system.
     * The book is stored in a Map that contains the book and the amount available.
     * If the book already exists, the amount increases by 1; if new, the amount is 1.
     *
     * @param book The book to store in the map.
     * @return true if the book was stored, false otherwise.
     */
    public boolean addBook(Book book) {
        // TODO: Implement the logic to add a new book into the map.
        return false;
    }

    /**
     * Creates a new loan for the User identified by userId and the book identified by isbn.
     * Validates book availability, user existence, and that the user doesn't already 
     * have an ACTIVE loan for the same book.
     *
     * @param userId id of the user.
     * @param isbn   book identification.
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        // TODO: Implement the logic of loan a book to a user.
        return null;
    }

    /**
     * Returns a loan, increases the book stock, sets status to RETURNED 
     * and sets the return date to current date.
     *
     * @param loan loan to return.
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        // TODO: Implement the logic of returning a book.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }
}