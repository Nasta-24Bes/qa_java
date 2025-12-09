package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetSoundReturnsCorrectSound() {
        Cat cat = new Cat(felineMock);
        assertEquals("Метод getSound должен возвращать 'Мяу'",
                "Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();

        assertEquals("Метод getFood должен возвращать еду от Feline",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        cat.getFood();

        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Test exception"));

        Cat cat = new Cat(felineMock);
        cat.getFood();
    }
}