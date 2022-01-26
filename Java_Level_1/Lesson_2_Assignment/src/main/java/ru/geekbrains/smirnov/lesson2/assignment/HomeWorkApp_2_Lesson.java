package ru.geekbrains.smirnov.lesson2.assignment;

public class HomeWorkApp_2_Lesson {

    // Практические задания к уроку №2
    public static void main(String[] args){

        System.out.println("Задание №1:");
        System.out.println(amountRange10to20( 4, 8) + "\n");

        System.out.println("Задание №2:");
        isPositiveOrNegativeNumber(5);

        System.out.println("Задание №3:");
        System.out.println(retPositiveOrNegativeNumber( 7) + "\n");

        System.out.println("Задание №4:");
        printWordNTime("Текст для задания №4", 6);
        System.out.println(""); // Добавил строку чтобы отделить 4 задание от 5

        System.out.println("Задание №5:");
        System.out.println(leapYear(2000));
    }

    // Задание №1
    public static boolean amountRange10to20(int a, int b){

        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // Задание №2
    public static void isPositiveOrNegativeNumber (int c){

        if (c >= 0){
            System.out.println("Заданое число является положительным.\n");
        } else {
            System.out.println("Заданое число является отрийательным.\n");
        }
    }

    // Задание №3
    public static boolean retPositiveOrNegativeNumber(int d){

        if (d < 0){
            return true;
        } else {
            return false;
        }
    }

    // Задание №4
    public static void printWordNTime(String text1, int e){
        for (int i = 0; i < e; i++){
            System.out.println(i+1 + ") " + text1);
        }
    }

    // Задание №5
    public static boolean leapYear(int year){
        if ((year %4 == 0) && (!(year %100 == 0) || (year %400 == 0))){
            return true;
        } else {
            return false;
        }
    }
}
