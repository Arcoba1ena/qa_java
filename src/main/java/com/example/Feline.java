package com.example;

import java.util.List;
import java.util.Arrays;

public class Feline extends Animal implements Predator {

    public List<String> felineAttributes = Arrays.asList("Самец", "Самка", "Оно",
            "Кошачьи", "Животные, Птицы, Рыба", "Мяу");

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}