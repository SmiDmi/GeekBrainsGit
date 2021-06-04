package ru.geekbrains.smirnov.lesson6.assignment;

public class Dog extends Animal {

    int maxRun = 500;
    int maxSwim = 10;

    Dog(int i) {
        super(i);
    }

    @Override
    public void type(){
        System.out.print("Собака ");
    }

    @Override
    public void run (int distance) {
        if ((distance >= 0) && (distance <= maxRun)) {
            System.out.print("Пробежала: " + distance + "м. ");
        } else {
            System.out.print(distance + " слишком большое расстояние для собаки. ");
        }
    }

    @Override
    public void swim (int distance) {
        if ((distance >= 0) && (distance <= maxSwim)) {
            System.out.print("Проплыла: " + distance + "м.\n");
        } else {
            System.out.print(distance + " слишком большое расстояние для собаки.\n");
        }
    }

}
