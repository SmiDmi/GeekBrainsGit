package ru.geekbrains.smirnov.lesson4.assignment;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp_4_Lesson {

//   1) Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
//   2) Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
//   3) * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
//      Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
//   (Не успел) 4) *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Ход человека.
    public static Scanner sc = new Scanner(System.in);
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    // Проверка ячеек.
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    // Ход компьютера.
    public static Random rand = new Random();
    public static void aiTurn() {

        int horizontal_line = 0; // Проверка по горизонтали
        int vertical_line = 0; // Проверка по вертикали
        int diagonal = 0; // Проверка по диагонялям в направлении \
        int revDiagonal = 0; // Проверка по диагоналям в направлении /

        int x, y;

        for (int i = 0; i <= SIZE - 1; i++) {
            for (int j = 0; j <= SIZE - 1; j++) {
                if (map[i][j] == DOT_X) {
                    horizontal_line++;
                    if (horizontal_line > 1 && horizontal_line < DOTS_TO_WIN) {
                        System.out.println("Компьютер походил в точку " + (i + 1) + " " + (j + 1));
                        map[i][j] = DOT_O;
                    }
                } else {
                    break;
                }
                if (map[j][i] == DOT_X) {
                    vertical_line++;
                    if (vertical_line > 1 && vertical_line < DOTS_TO_WIN) {
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        map[j][i] = DOT_O;
                    }
                } else {
                    break;
                }
            }
            if (map[i][i] == DOT_X) {
                diagonal++;
                if (diagonal > 1 && diagonal < DOTS_TO_WIN) {
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + (i + 1));
                    map[i][i] = DOT_O;
                }
            } else {
                break;
            }
            if (map[i][SIZE - 1 - i] == DOT_X) {
                revDiagonal++;
                if (revDiagonal > 1 && revDiagonal < DOTS_TO_WIN) {
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + ((SIZE - 1 - i) + 1));
                    map[i][SIZE - 1 - i] = DOT_O;
                }
            } else {
                break;
            }
        }

        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    // Проверка победы.
    public static boolean checkWin(char symb) {

        int horizontal_line = 0; // Проверка по горизонтали
        int vertical_line = 0; // Проверка по вертикали
        int diagonal = 0; // Проверка по диагонялям в направлении \
        int revDiagonal = 0; // Проверка по диагоналям в направлении /

        for (int i = 0; i <= SIZE - 1; i++) {
            for (int j = 0; j <= SIZE - 1; j++) {
                if (map[i][j] == symb) {
                    horizontal_line++;
                    if (horizontal_line == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    horizontal_line = 0;
                }
                if (map[j][i] == symb) {
                    vertical_line++;
                    if (vertical_line == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    vertical_line = 0;
                }
            }
            if (map[i][i] == symb) {
                diagonal++;
                if (diagonal == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                diagonal = 0;
            }
            if (map[i][SIZE - 1 - i] == symb) {
                revDiagonal++;
                if (revDiagonal == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                revDiagonal = 0;
            }
        }
        return false;
    }
}
