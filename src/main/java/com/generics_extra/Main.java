package com.generics_extra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.generics_extra.model.LPAStudent;
import com.generics_extra.model.LPAStudentComparator;
import com.generics_extra.model.Student;
import com.generics_extra.util.QueryItem;
import com.generics_extra.util.QueryList;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }

}

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printMoreLists(lpaStudents);
        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");

        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);

        // QueryList<Employee> employeeList = new QueryList<>();

        QueryList<LPAStudent> queryListN = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryListN.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryListN.sort(Comparator.naturalOrder());
        printList(queryListN);

        System.out.println("Matches");
        var matchesN = queryListN.getMatches("PercentComplete", "50").getMatches("Course", "Python");
        matchesN.sort(new LPAStudentComparator());
        printList(matchesN);

        System.out.println("Ordered");
        matchesN.sort(null);
        printList(matchesN);
    }

    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }

    public static <T> void printMoreLists(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    // public static void testList(List<String> list) {
    // for (var element : list) {
    // System.out.println("String: " + element.toUpperCase());
    // }
    // }
    // public static void testList(List<Integer> list) {
    // for (var element : list) {
    // System.out.println("Integer: " + element.floatValue());
    // }
    // }

    // public static <T extends Student> void printList(List<T> students) {
    // for (var student : students) {
    // System.out.println(student.getYearStarted() + ": " + student);
    // }
    // System.out.println();
    // }

}