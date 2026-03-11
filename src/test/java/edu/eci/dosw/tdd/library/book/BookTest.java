package edu.eci.dosw.tdd.library.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldReturnBookFields() {
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884");

        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals("9780132350884", book.getIsbn());
    }

    @Test
    void shouldConsiderBooksEqualByIsbn() {
        Book first = new Book("A", "B", "ISBN-1");
        Book second = new Book("Other title", "Other author", "ISBN-1");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldHandleBookInequalityCases() {
        Book book = new Book("A", "B", "ISBN-1");
        Book different = new Book("A", "B", "ISBN-2");

        assertNotEquals(book, null);
        assertNotEquals(book, "not a book");
        assertNotEquals(book, different);
    }
}
