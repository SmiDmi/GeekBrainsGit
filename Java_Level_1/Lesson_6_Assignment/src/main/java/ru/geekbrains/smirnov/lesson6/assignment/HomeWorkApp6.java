package ru.geekbrains.smirnov.lesson6.assignment;


//      1. Создать классы Собака и Кот с наследованием от класса Животное.
//      2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//      Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//      3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//      4. * Добавить подсчет созданных котов, собак и животных.

public class HomeWorkApp6 {

    public static void main(String[] args) {

        int countDog = 0;
        int countCat = 0;

        Animal[] pets = {
                new Dog(countDog++),
                new Dog(countDog++),
                new Dog(countDog++),
                new Dog(countDog++),
                new Cat(countCat++),
                new Cat(countCat++),
                new Cat(countCat++)
        };
        for (Animal pet : pets) {
            pet.type();
            pet.name();  // В голову внезапно пришла идея рандомного имени петомца. Но иногда они повторяются. Наверно пул имен нужно сделать побольше.
            pet.run(150);
            pet.swim(6);
        }
        System.out.println("Собак: " + countDog + "\nКошек: " + countCat + "\nВсего животных: " + (countDog + countCat));
    }

}
