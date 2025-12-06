package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(predatorMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(predatorMock);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}