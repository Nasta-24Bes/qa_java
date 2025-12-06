package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void testAlexBasicProperties() throws Exception {
        Alex alex = new Alex(predatorMock);

        // Проверяем базовые свойства
        assertNotNull(alex);
        assertTrue(alex.doesHaveMane());
        assertEquals(0, alex.getKittens());
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());

        // Проверяем друзей
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    public void testAlexGetFood() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Еда"));

        Alex alex = new Alex(predatorMock);
        List<String> food = alex.getFood();

        assertNotNull(food);
        verify(predatorMock).eatMeat();
    }
}