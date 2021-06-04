package ru.geekbrains.smirnov.lesson6.assignment;

public class Cat extends Animal {

    int maxRun = 200;

    Cat(int countCat) {
        super(countCat);
    }

    @Override
    public void type(){
        System.out.print("Кошка ");
    }

    @Override
    public void run(int distance) {
        if ((distance >= 0) && (distance <= maxRun)) {
            System.out.print("Пробежала: " + distance + "м. ");
        } else {
            System.out.print(distance + "м. слишком большое расстояние для кошки. ");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.print("Кошки не плавают.\n");
    }

}
