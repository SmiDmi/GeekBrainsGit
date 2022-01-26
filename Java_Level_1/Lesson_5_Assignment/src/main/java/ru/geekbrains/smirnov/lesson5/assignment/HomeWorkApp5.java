package ru.geekbrains.smirnov.lesson5.assignment;

//    4. Создать массив из 5 сотрудников.
//    Пример:
//    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//    persArray[1] = new Person(...);
//    ...
//    persArray[4] = new Person(...)
//    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.


public class HomeWorkApp5 {

// ФИО
// Должность
// Email
// Телефон
// Оплата труда
// Возраст

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
            employees[0] = new Employee("Иванов Иван Иванович","Руководитель отдела продаж","ivanov@mail.ru", "+7(926)384-29-74","80000 руб./мес.", 49);
            employees[1] = new Employee("Петров Николай Григорьевич","Курьер","npetrov@mail.ru", "+7(905)167-02-95","25000 руб./мес.", 18);
            employees[2] = new Employee("Агафонов Никита Сергеевич","Менеджер","nagafonov@mail.ru", "+7(918)524-37-91","40000 руб./мес.", 35);
            employees[3] = new Employee("Сидорова Мария Андреевна","Бухгалтер","msidorova@mail.ru", "+7(903)068-54-11","90000 руб./мес.", 42);
            employees[4] = new Employee("Шпак Артемий Викторович","Сын генерального директора","ashpak@mail.ru", "+7(925)777-77-77","120000 руб./мес.", 27);

        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getAge() > 40){
                employees[i].printInfo();
            }
        }
    }

}
