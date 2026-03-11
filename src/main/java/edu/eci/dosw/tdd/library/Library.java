package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;

import java.time.LocalDateTime;
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
        if (book == null || book.getIsbn() == null || book.getIsbn().isBlank()) {
            return false;
        }

        books.merge(book, 1, Integer::sum);
        return true;
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
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null || book == null) {
            return null;
        }

        Integer available = books.get(book);
        if (available == null || available <= 0) {
            return null;
        }

        boolean userHasActiveLoanForBook = loans.stream()
                .anyMatch(loan -> loan.getUser().getId().equals(userId)
                        && loan.getBook().getIsbn().equals(isbn)
                        && loan.getStatus() == LoanStatus.ACTIVE);

        if (userHasActiveLoanForBook) {
            return null;
        }

        books.put(book, available - 1);
        Loan loan = new Loan(book, user, LocalDateTime.now(), LoanStatus.ACTIVE);
        loans.add(loan);
        return loan;
    }

    /**
     * Returns a loan, increases the book stock, sets status to RETURNED 
     * and sets the return date to current date.
     *
     * @param loan loan to return.
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        if (loan == null || loan.getBook() == null || loan.getStatus() != LoanStatus.ACTIVE) {
            return null;
        }

        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        books.merge(loan.getBook(), 1, Integer::sum);
        return loan;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    private User findUserById(String userId) {
        if (userId == null || userId.isBlank()) {
            return null;
        }
        return users.stream()
                .filter(user -> userId.equals(user.getId()))
                .findFirst()
                .orElse(null);
    }

    private Book findBookByIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            return null;
        }
        return books.keySet().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst()
                .orElse(null);
    }
}