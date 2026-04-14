package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AlexTest {

    private Alex alex;

    @Test
    void setUp() throws Exception {
        alex = new Alex();
    }

    @Test
    void testGetKittens() throws Exception {
        setUp();
        assertEquals(0, alex.getKittens());
    }

    @Test
    void testDoesHaveMane() throws Exception {
        setUp();
        assertTrue(alex.doesHaveMane()); // Алекс — самец, у него есть грива
    }

    @Test
    void testGetFriends() throws Exception {
        setUp();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void testGetPlaceOfLiving() throws Exception {
        setUp();
        assertEquals("Нью‑Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void testGetFood() throws Exception {
        setUp();
        List<String> food = alex.getFood();
        assertNotNull(food);
        assertFalse(food.isEmpty());
    }
}
