package com.example;

import java.util.List;

public interface Predator {
    List<String> eatMeat() throws Exception;
    String getFamily(); // Добавляем, чтобы Lion мог его использовать
    int getKittens();
}