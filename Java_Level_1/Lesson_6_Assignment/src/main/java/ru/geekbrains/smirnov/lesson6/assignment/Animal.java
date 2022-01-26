package ru.geekbrains.smirnov.lesson6.assignment;

import java.util.Random;

public abstract class Animal {


    public Animal(int i) {
    }

    public abstract void type();

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public void name(){
        String[] name = {"Барсик ", "Рич ", "Чак ", "Сосиська ", "Лаки ", "Веник ", "Люмка ", "Лапка ", "Кекс ", "Тосик ", "Вилка "};
        Random random = new Random();
        String randomName = name[random.nextInt(11)];
        System.out.print("по кличке " + randomName);
    }
}

