package ru.geekbrains.smirnov.lesson1.assignment;

    // Задание N1 
    // (Пришлось внести изменение в файл в виде комментария, чтобы отобразить его отдельно в Pull requests)
public class HomeWorkApp {
    public static void main(String[] args){

        // Задание №6
        System.out.println("Задание №2:");
        printThreeWords();

        System.out.println("Задание №3:");
        checkSumSign();

        System.out.println("Задание №4:");
        printColor();

        System.out.println("Задание №5:");
        compareNumbers();
    }

    // Задание N2
    private static void printThreeWords(){

        var _Orange = "Orange";
        var _Banana = "Banana";
        var _Apple = "Apple";

        System.out.println(_Orange);
        System.out.println(_Banana);
        System.out.println(_Apple + "\n");

    }

    // Задание N3
    static void checkSumSign(){

        int a = 3;
        int b = 5;
        int c = a + b;

        if(c >= 0){
            System.out.println("Сумма положительная \n");
        } else {
            System.out.println("Сумма отрицательная \n");
        }
    }

    // Задание N4
    static void printColor(){

        int value = 70;

        if (value <= 0){
            System.out.println("Красный \n");
        } else if (value > 0 && value <= 100){
            System.out.println("Желтый \n");
        } else if (value > 100){
            System.out.println("Зеленый \n");
        } else {
            System.out.println("Некорректное значение переменной value. \n");
        }
    }

    // Задание N5
    static void compareNumbers(){

        int a = 4;
        int b = 4;

        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
