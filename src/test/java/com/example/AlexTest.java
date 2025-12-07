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
    private Feline felineMock;

    @Test
    public void testConstructorCreatesMaleLion() throws Exception {
        Alex alex = new Alex(felineMock);
        assertTrue("Алекс должен быть самцом", alex.doesHaveMane());
    }

    @Test
    public void testGetFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals("Список друзей должен соответствовать ожидаемому",
                expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals("Место жительства должно быть Нью-Йоркский зоопарк",
                "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensAlwaysReturnsZero() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals("У Алекса всегда должно быть 0 львят",
                0, alex.getKittens());
    }

    @Test
    public void testGetFoodCallsFelineMethod() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Alex alex = new Alex(felineMock);
        List<String> actualFood = alex.getFood();

        assertEquals("Еда должна совпадать", expectedFood, actualFood);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Нет еды"));
        Alex alex = new Alex(felineMock);
        alex.getFood();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testFriendsListIsImmutable() throws Exception {
        Alex alex = new Alex(felineMock);
        alex.getFriends().add("Новый друг");
    }

    @Test
    public void testFriendsListHasCorrectOrder() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> friends = alex.getFriends();
        assertEquals("Первый друг должен быть Марти", "Марти", friends.get(0));
        assertEquals("Второй друг должна быть Глория", "Глория", friends.get(1));
        assertEquals("Третий друг должен быть Мелман", "Мелман", friends.get(2));
    }
}