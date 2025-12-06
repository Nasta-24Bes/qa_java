package com.example;

import java.util.Arrays;
import java.util.List;

public class Alex extends Lion {

    public Alex(Predator predator) throws Exception {
        // Алекс всегда самец
        super("Самец", predator);
    }

    @Override
    public int getKittens() {
        // У Алекса нет львят
        return 0;
    }

    /**
     * Возвращает список имён друзей Алекса
     * @return список имён: зебра Марти, бегемотиха Глория, жираф Мелман
     */
    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    /**
     * Возвращает место жительства Алекса
     * @return "Нью-Йоркский зоопарк"
     */
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}