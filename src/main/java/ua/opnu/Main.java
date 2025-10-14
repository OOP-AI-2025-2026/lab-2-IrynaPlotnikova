package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Створення нового студента");
        Student student1 = new Student("Марія Петренко", 1);
        System.out.println("Ім'я: " + student1.getName());
        System.out.println("Курс: " + student1.getYear());
        System.out.println("Вартість навчання: " + student1.getTuition() + " грн");
        System.out.println("Кількість курсів: " + student1.getCourseCount());
        System.out.println("");

        System.out.println("Додавання курсів");
        student1.addCourse("ООП");
        student1.addCourse("Бази даних");
        student1.addCourse("Українська мова");
        List<String> currentCourses = student1.getCourses();
        System.out.println("Список курсів студента " + student1.getName() + ": " + currentCourses);
        System.out.println("Поточна кількість курсів: " + student1.getCourseCount());
        System.out.println("");

        System.out.println("Переведення на наступний курс");
        student1.promoteToNextYear();
        System.out.println("Новий курс студента: " + student1.getYear());
        System.out.println("Нова вартість навчання: " + student1.getTuition() + " грн");
        System.out.println("");

        System.out.println("Зміна прізвища");
        student1.changeLastName("Іваненко");
        System.out.println("Нове повне ім'я студента: " + student1.getName());
        System.out.println("");

        System.out.println("Видалення одного курсу");
        boolean isRemoved = student1.removeCourse("Бази даних");
        if (isRemoved)
            System.out.println("Курс 'Бази даних' успішно видалено.");
        else
            System.out.println("Курс 'Бази даних' не знайдено.");

        System.out.println("Оновлений список курсів: " + student1.getCourses());
        System.out.println("");

        System.out.println("Видалення всіх курсів");
        student1.dropAll();
        System.out.println("Всі курси було видалено.");
        System.out.println("Кількість курсів після видалення: " + student1.getCourseCount());
        System.out.println("");
    }
    }