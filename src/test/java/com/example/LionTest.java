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
    private Feline felineMock;

    @Test
    public void testConstructorWithMaleSexCreatesLionWithMane() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue("Лев-самец должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithFemaleSexCreatesLionWithoutMane() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse("Львица не должна иметь гриву", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorWithNullFelineThrowsException() throws Exception {
        new Lion("Самец", null);
    }

    @Test
    public void testConstructorWithNullFelineExceptionMessage() {
        try {
            new Lion("Самец", null);
            fail("Должно быть выброшено исключение при null feline");
        } catch (Exception e) {
            assertEquals("Feline не может быть null", e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный", felineMock);
    }

    @Test
    public void testConstructorWithInvalidSexExceptionMessage() {
        try {
            new Lion("Неизвестный", felineMock);
            fail("Должно быть выброшено исключение при невалидном поле");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testConstructorWithNullSexThrowsException() throws Exception {
        new Lion(null, felineMock);
    }

    @Test
    public void testConstructorWithNullSexExceptionMessage() {
        try {
            new Lion(null, felineMock);
            fail("Должно быть выброшено исключение при null поле");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        int kittens = lion.getKittens();

        assertEquals("getKittens должен возвращать значение от Feline",
                3, kittens);
    }

    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        lion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", felineMock);
        List<String> actualFood = lion.getFood();

        assertEquals("getFood должен возвращать еду от Feline",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineMethod() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", felineMock);
        lion.getFood();

        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesExceptionFromFeline() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Test exception"));

        Lion lion = new Lion("Самец", felineMock);
        lion.getFood();
    }
}