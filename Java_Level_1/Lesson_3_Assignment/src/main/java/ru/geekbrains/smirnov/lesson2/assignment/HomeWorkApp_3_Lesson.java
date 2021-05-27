package ru.geekbrains.smirnov.lesson2.assignment;

public class HomeWorkApp_3_Lesson {

    public static void main(String[] args) {

        System.out.println("Задание №1:");
        invertArray();
        System.out.println(""); // Просто отступ в консоли

        System.out.println("\nЗадание №2:");
        fillArray();
        System.out.println(""); // Просто отступ в консоли

        System.out.println("\nЗадание №3:");
        changeArray();
        System.out.println(""); // Просто отступ в консоли

        System.out.println("\nЗадание №4:");
        fillDiagonal();

        System.out.println("\nЗадание №5:");
        masArrayInt(8, 16);
        System.out.println(""); // Просто отступ в консоли

        System.out.println("\nЗадание №6:");
        arrayMaxAndMin();
        System.out.println(""); // Просто отступ в консоли

        System.out.println("\nЗадание №7:");
        System.out.println(arrayPartsComparison());
    }

    // Задание №1
    public static void invertArray() {
        int[] arr = {1, 1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
    }

    // Задание №2
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    // Задание №3
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            } else {
                arr[i] = arr[i];
            }
            System.out.print(arr[i] + " ");
        }
    }

    // Задание №4
    public static void fillDiagonal() {
        int[][] arr = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задание №5
    public static void masArrayInt(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    }

    // Задание №6
    public static void arrayMaxAndMin() {
        int[] arr = {5, 24, 0, -6, 21, 2, 15, 3, 1, 11, -2, 32};
        int max = arr[0];
        int min = arr[0];
        System.out.print("Массив имеет вид: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println("\nМинимальное число массива: " + min + "\nМаксимальное число массива: " + max);
    }

    // Задание №7
    // Так я и не смог ослилить. Не понял как сложения делалать. =((
    public static boolean arrayPartsComparison() {
        int[] arr = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        for (int i = 0; i < arr.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                // считаем сумму sum1 от начала до i
            }
            for (int j = i; j < arr.length; j++) {
                // считаем сумму от i до конца
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }
}
