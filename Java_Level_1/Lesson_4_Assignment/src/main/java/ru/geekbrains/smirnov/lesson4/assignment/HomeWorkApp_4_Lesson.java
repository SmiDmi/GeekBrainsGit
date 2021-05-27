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
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    // Проверка победы.
    public static boolean checkWin(char symb) {

        int horizontal_line, vertical_line; // Горизонтальные и вертикальные линии для проверки
        int diagonal, revDiagonal; // Диагонали в разных направлениях

        for (int i = 0; i < SIZE; i++) {
            horizontal_line = 0;
            vertical_line = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    horizontal_line++;
                } else if (map[i][j] != symb && horizontal_line < DOTS_TO_WIN) {
                    horizontal_line = 0;
                }
                if (map[j][i] == symb) {
                    vertical_line++;
                }   else if (map[j][i] != symb && vertical_line < DOTS_TO_WIN) {
                    vertical_line = 0;
                }
                if (horizontal_line >= DOTS_TO_WIN || vertical_line >= DOTS_TO_WIN) {
                    return true;
                }
            }
            for (int j = 0; j < SIZE; j++) {
                diagonal = 0;
                for (i = 0; i < SIZE; i++) {
                    int k = j + i;
                    if (k < SIZE) {
                        if (map[i][k] == symb) {
                            diagonal++;
                        } else if (map[i][k] != symb && diagonal < DOTS_TO_WIN) {
                            diagonal = 0;
                        }
                    }
                    if (diagonal >= DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            for (int j = 1; j < SIZE; j++) {
                diagonal = 0;
                for (i = 0; i < SIZE; i++) {
                    int k = j + i;
                    if (k < SIZE) {
                        if (map[k][i] == symb) {
                            diagonal++;
                        } else if (map[k][i] != symb && diagonal < DOTS_TO_WIN) {
                            diagonal = 0;
                        }
                    }
                    if (diagonal >= DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            for (int j = 0; j < SIZE; j++) {
                revDiagonal = 0;
                for (i = 0; i < SIZE; i++) {
                    int k = (SIZE - 1) - i;
                    int l = j + i;
                    if (k >= 0 && l < SIZE) {
                        if (map[l][k] == symb) {
                            revDiagonal++;
                        } else if (map[l][k] != symb && revDiagonal < DOTS_TO_WIN) {
                            revDiagonal = 0;
                        }
                    }
                    if (revDiagonal >= DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            for (int j = 1; j < SIZE; j++) {
                revDiagonal = 0;
                for (i = 0; i < SIZE; i++) {
                    int k = (SIZE - 1) - j - i;
                    if (k >= 0) {
                        if (map[i][k] == symb) {
                            revDiagonal++;
                        } else if (map[i][k] != symb && revDiagonal < DOTS_TO_WIN) {
                            revDiagonal = 0;
                        }
                    }
                    if (revDiagonal >= DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
