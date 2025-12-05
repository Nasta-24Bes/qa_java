package com.example;

import java.util.List;

public class Lion implements Predator {

    private final Feline feline;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if (!"Самец".equals(sex) && !"Самка".equals(sex)) {
            throw new Exception("Используйте допустимые значения пола - Самец или Самка");
        }
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return feline.eatMeat();
    }


    @Override
    public String getFamily() {
        return feline.getFamily();
    }


    public int getKittens() {
        return feline.getKittens();
    }
}
