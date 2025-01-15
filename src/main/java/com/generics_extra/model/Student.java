package com.generics_extra.model;

import java.util.Random;

import com.generics_extra.util.QueryItem;

public class Student implements QueryItem, Comparable<Student> {
    private String name;
    private String course;
    private static int Last_ID = 10_000;
    private int studentId;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] firstNames = { "Ann", "Bill", "Cathy", "John", "Tim" };
    private static String[] courses = { "C++", "Java", "Python" };

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        studentId = Last_ID++;

        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2024);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(studentId).compareTo(o.studentId);
    }

}
