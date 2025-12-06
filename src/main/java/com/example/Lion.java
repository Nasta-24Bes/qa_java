package com.example;

import java.util.List;

public class Lion implements Predator {

    private final Predator predator;

    public Lion(Predator predator, String sex) throws Exception {
        this.predator = predator;
        if (!"Самец".equals(sex) && !"Самка".equals(sex)) {
            throw new Exception("Используйте допустимые значения пола - Самец или Самка");
        }
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return predator.eatMeat();
    }

    @Override
    public String getFamily() {
        return predator.getFamily();
    }

    @Override
    public int getKittens() {
        return predator.getKittens();
    }

    public boolean hasMane() throws Exception {
        // Логика определения гривы
        return true; // упрощенный пример
    }
}