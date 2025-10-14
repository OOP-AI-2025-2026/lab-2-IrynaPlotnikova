package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private List<String> courses;
    private final int COST_PER_YEAR = 20000;

    public Student(String name, int year) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім.");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути в діапазоні від 1 до 4.");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void changeLastName(String newLastName) {
        if (newLastName == null || newLastName.trim().isEmpty()) {
            System.out.println("Помилка: Нове прізвище не може бути порожнім.");
            return;
        }
        String firstName = this.name.split(" ")[0];
        this.name = firstName + " " + newLastName.trim();
    }

    public void promoteToNextYear() {
        if (year < 4)
            year++;
    }

    public boolean removeCourse(String courseName) {
        return this.courses.remove(courseName);
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.trim().isEmpty())
            courses.add(courseName);
    }

    public void dropAll() {
        courses.clear();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public List<String> getCourses() {
        return courses;
    }

    public int getTuition() {
        return year * COST_PER_YEAR;
    }
}