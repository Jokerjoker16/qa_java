package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    static Stream<Arguments> provideSexAndMane() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSexAndMane")
    void testLionConstructorAndDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    void testLionConstructorInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный пол", feline);
        });
        assertTrue(exception.getMessage().contains("Используйте допустимые значения"));
    }

    @Test
    void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        lion = new Lion("Самец", feline);
        assertEquals(5, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> mockFood = List.of("Животные", "Птицы");
        when(feline.getFood("Хищник")).thenReturn(mockFood);
        lion = new Lion("Самец", feline);
        assertEquals(mockFood, lion.getFood());
    }
}
