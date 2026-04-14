package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void testGetKittensWithParameter(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
