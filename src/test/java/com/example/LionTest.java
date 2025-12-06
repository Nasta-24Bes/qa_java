package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void testConstructorValidMale() throws Exception {
        Lion lion = new Lion("Самец", predatorMock);
        assertNotNull(lion);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorValidFemale() throws Exception {
        Lion lion = new Lion("Самка", predatorMock);
        assertNotNull(lion);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testConstructorInvalidSex() {
        // Проверяем 3 варианта невалидного пола
        String[] invalidSexes = {"Неизвестный", null, ""};

        for (String sex : invalidSexes) {
            try {
                new Lion(sex, predatorMock);
                fail("Должно быть исключение для пола: " + sex);
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка",
                        e.getMessage());
            }
        }
    }

    @Test
    public void testGetKittensBothBranches() throws Exception {
        // Ветка 1: Feline
        Feline feline = new Feline();
        Lion lion1 = new Lion("Самец", feline);
        assertEquals(1, lion1.getKittens());

        // Ветка 2: Не Feline
        Lion lion2 = new Lion("Самка", predatorMock);
        assertEquals(0, lion2.getKittens());
    }

    @Test
    public void testGetFoodNormal() throws Exception {
        List<String> expected = List.of("Еда");
        when(predatorMock.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(expected, lion.getFood());
        verify(predatorMock).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        new Lion("Самка", predatorMock).getFood();
    }
}