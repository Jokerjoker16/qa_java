package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AlexTest {

    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex();
    }

    @Test
    void testGetKittens() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    void testDoesHaveMane() throws Exception {
        assertTrue(alex.doesHaveMane()); // Алекс — самец, у него есть грива
    }

    @Test
    void testGetFriends() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void testGetPlaceOfLiving() {
        assertEquals("Нью‑Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void testGetFoodIsNotNull() throws Exception {
        List<String> food = alex.getFood();
        assertNotNull(food);
    }

    @Test
    void testGetFoodIsNotEmpty() throws Exception {
        List<String> food = alex.getFood();
        assertFalse(food.isEmpty());
    }
}
