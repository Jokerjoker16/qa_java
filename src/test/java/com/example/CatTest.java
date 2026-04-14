package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> mockFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(mockFood);
        assertEquals(mockFood, cat.getFood());
    }
}
