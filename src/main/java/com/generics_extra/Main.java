package com.generics_extra;

import java.util.ArrayList;
import java.util.List;

import com.generics_extra.model.LPAStudent;
import com.generics_extra.model.Student;

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
    }

    public static <T> void printMoreLists(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            }
        }
    }


    // public static void testList(List<String> list) {
    //     for (var element : list) {
    //         System.out.println("String: " + element.toUpperCase());
    //     }
    // }
    // public static void testList(List<Integer> list) {
    //     for (var element : list) {
    //         System.out.println("Integer: " + element.floatValue());
    //     }
    // }

    // public static <T extends Student> void printList(List<T> students) {
    // for (var student : students) {
    // System.out.println(student.getYearStarted() + ": " + student);
    // }
    // System.out.println();
    // }
}