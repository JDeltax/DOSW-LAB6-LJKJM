package edu.eci.dosw.tdd.library.loan;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {

    @Test
    void shouldGetAndSetLoanData() {
        Book book = new Book("T1", "A1", "I1");
        User user = new User("John", "U1");
        LocalDateTime loanDate = LocalDateTime.now().minusDays(1);

        Loan loan = new Loan(book, user, loanDate, LoanStatus.ACTIVE);

        assertEquals(book, loan.getBook());
        assertEquals(user, loan.getUser());
        assertEquals(loanDate, loan.getLoanDate());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());

        Book newBook = new Book("T2", "A2", "I2");
        User newUser = new User("Jane", "U2");
        LocalDateTime newLoanDate = LocalDateTime.now();
        LocalDateTime returnDate = LocalDateTime.now().plusDays(7);

        loan.setBook(newBook);
        loan.setUser(newUser);
        loan.setLoanDate(newLoanDate);
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(returnDate);

        assertEquals(newBook, loan.getBook());
        assertEquals(newUser, loan.getUser());
        assertEquals(newLoanDate, loan.getLoanDate());
        assertEquals(LoanStatus.RETURNED, loan.getStatus());
        assertEquals(returnDate, loan.getReturnDate());
    }
}
