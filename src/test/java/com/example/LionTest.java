package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Lion lion;

    static Stream<Arguments> provideSexAndMane() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSexAndMane")
    void testLionConstructorAndDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex, feline);
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
        Lion lion = new Lion("Самец", feline

    @Test
    void testGetFood() throws Exception {
            List<String> mockFood = List.of("Животные", "Птицы");
        }
            when(feline.getFood("Хищник")).thenReturn(mockFood);
            Lion lion = new Lion("Самец", feline);
            assertEquals(mockFood, lion.getFood());
        }
    }
