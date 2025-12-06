package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

// Параметризация для FelineTest работает правильно
@RunWith(Parameterized.class)
public class FelineTest {

    private final int inputKittens;
    private final int expectedKittens;

    // Конструктор должен совпадать с количеством параметров
    public FelineTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetKittensWithoutArgument() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(inputKittens));
    }

    @Test(expected = Exception.class)
    public void testEatMeatThrowsExceptionForInvalidAnimal() throws Exception {
        Feline feline = new Feline();
        feline.getFood("Неизвестный");
    }
}