package com.muhammedokumus;


import com.muhammedokumus.coursestructure.Course;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        //Course myCourse = new Course(1, "CSE 222", "Data Structures and Algorithims", 8, 6,"5+0+0");
        //System.out.println(myCourse);

        CourseManagementSystem cms = new CourseManagementSystem("Files/Courses.csv");
        //System.out.println(cms);

        System.out.println("\n*************************** Scenario 1 ***************************");
        System.out.println("Accessing a course by code and manipulating given reference.");
        Course test1 = cms.get("CSE 107");
        System.out.println("Unedited: " + test1);

        System.out.println("        test1.setCourseCode(\"105\");\n" +
                "        test1.setCourseTitle(\"Extra Hard New C Programming Lab\");\n" +
                "        test1.setSemester(\"2\");\n" +
                "        test1.setEctsCredit(\"10\");\n" +
                "        test1.setGtuCredit(\"8\");\n" +
                "        test1.setCreditWeight(\"0+0+10\");");

        test1.setCourseCode("105");
        test1.setCourseTitle("Extra Hard New C Programming Lab");
        test1.setSemester("2");
        test1.setEctsCredit("10");
        test1.setGtuCredit("8");
        test1.setCreditWeight("0+0+10");

        System.out.println("Edited : " + test1);
        System.out.println("Note: This is my get method, not getByCode method difference is one returns reference, other just prints.");
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 2 ***************************");
        System.out.println("Trying to access to element with an invalid course code.");
        try{
            Course test2 = cms.get("CSI 407");
        } catch (NoSuchElementException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 3 ***************************");
        System.out.println("Trying to access with optional course code XXX XXX.");
        try{
            Course test3 = cms.get("XXX XXX");
        } catch (IllegalArgumentException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 4 ***************************");
        System.out.println("Trying to access with index and manipulate.");

        Course test4 = cms.get(1);
        System.out.println("Unedited: " + test4);

        test4.setCourseCode("255");
        test4.setCourseTitle("İş Hayatı İçin İnglizce");
        test4.setSemester("1");
        test4.setEctsCredit("4");
        test4.setGtuCredit("2");
        test4.setCreditWeight("2+1+1");

        System.out.println(
                "        test4.setCourseCode(\"255\");\n" +
                "        test4.setCourseTitle(\"İş Hayatı İçin İnglizce\");\n" +
                "        test4.setSemester(\"1\");\n" +
                "        test4.setEctsCredit(\"4\");\n" +
                "        test4.setGtuCredit(\"2\");\n" +
                "        test4.setCreditWeight(\"2+1+1\"); ");

        System.out.println("Edited: " + test4);
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 5 ***************************");
        System.out.println("Trying to access to out of range index.");
        try{
            Course test5 = cms.get(-1);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");
    }



}
