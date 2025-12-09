package com.example;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeatReturnsCorrectFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Метод eatMeat должен возвращать правильную еду",
                expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetKittensReturnsOneWhenNoArgument() {
        Feline feline = new Feline();
        assertEquals("getKittens без аргументов должен возвращать 1",
                1, feline.getKittens());
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Feline feline = new Feline();
        feline.getFood("Неизвестный");
    }

    @Test
    public void testGetFoodExceptionHasCorrectMessage() {
        Feline feline = new Feline();
        try {
            feline.getFood("Неизвестный");
            fail("Должно быть выброшено исключение");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }
}