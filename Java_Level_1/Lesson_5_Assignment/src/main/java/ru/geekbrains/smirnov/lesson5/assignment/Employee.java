package ru.geekbrains.smirnov.lesson5.assignment;

 //    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 //    2. Конструктор класса должен заполнять эти поля при создании объекта.
 //    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.



public class Employee {

    private String fullName; // ФИО
    private String position; // Должность
    private String email; // Email
    private String telephone; // Телефон
    private String salary; // Оплата труда
    private int age; // Возраст

    public Employee(String fullName, String position, String email, String telephone, String salary, int age) {

        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {  // Геттер для поля возраст.
        return age;
    }

    public void printInfo(){
        System.out.println("ФИО: " +fullName+ ", Должность: " +position+ ", E-mail: " +email+ ", Телефон: " +telephone+ ", Зарплата: " +salary+ ", Возраст: " +age);
    }
}
