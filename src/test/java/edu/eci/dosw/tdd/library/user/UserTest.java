package edu.eci.dosw.tdd.library.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void shouldGetAndSetUserData() {
        User user = new User("John", "U-1");

        assertEquals("John", user.getName());
        assertEquals("U-1", user.getId());

        user.setName("Jane");
        user.setId("U-2");

        assertEquals("Jane", user.getName());
        assertEquals("U-2", user.getId());
    }
}
