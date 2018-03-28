package com.muhammedokumus;


import com.muhammedokumus.coursestructure.BasicCourse;
import com.muhammedokumus.part3.part3CMS;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem("Files/Courses.csv");

        System.out.println("\n*************************** Scenario 1 ***************************");
        System.out.println("Accessing a course by code and manipulating given reference.");
        BasicCourse test1 = cms.get("CSE 107");
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
            BasicCourse test2 = cms.get("CSI 407");
        } catch (NoSuchElementException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 3 ***************************");
        System.out.println("Trying to access with optional course code XXX XXX.");
        try{
            BasicCourse test3 = cms.get("XXX XXX");
        } catch (IllegalArgumentException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 4 ***************************");
        System.out.println("Trying to access with index and manipulate.");

        BasicCourse test4 = cms.get(1);
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
            BasicCourse test5 = cms.get(-1);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e + "\nDidn't forward error to stderr for readability.");
        }
        System.out.println("******************************************************************");

        System.out.println("\n\n*************************** PART 2***************************");
        System.out.println("\n\n*************************** Scenario 1 ***************************");

        AdvancedCMS  advCms = new AdvancedCMS("Files/Courses.csv");

        System.out.println("Trying to disable a course by index.");
        System.out.println(advCms.get(3).getCourseCode() + " isAccessible: " + advCms.get(3).isAccessable());
        System.out.println("advCms.disable(3);");
        advCms.disable(3);
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 2 ***************************");
        System.out.println("Trying to disable a course by course code.");
        System.out.println(advCms.get("PHYS 152").getCourseCode() + " isAccessible: " + advCms.get("PHYS 152").isAccessable());
        System.out.println("advCms.disable(\"PHYS 152\");");
        advCms.disable("PHYS 152");
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 3 ***************************");
        System.out.println("Trying to enable a course by index.");
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("advCms.enable(3)");
        advCms.enable(3);
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 4 ***************************");
        System.out.println("Trying to enable a course by course code.");
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("advCms.enable(\"PHYS 152\");");
        advCms.enable("PHYS 152");
        System.out.println("advCms.showDisabled();");
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 5 ***************************");
        System.out.println("Disabling courses by code, then printing disabled courses with showDisabled() method");

        System.out.println("        advCms.disable(\"CSE 232\");\n" +
                "        advCms.disable(\"EN 112\");\n" +
                "        advCms.disable(\"CSE 211\");\n" +
                "        advCms.showDisabled();");

        advCms.disable("CSE 232");
        advCms.disable("EN 112");
        advCms.disable("CSE 211");
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 6 ***************************");
        System.out.println("Trying to set a course to different values.");
        BasicCourse aCourse = new BasicCourse("2", "TEST 101", "Is This Working?" , "1", "1", "1+0+0");
        System.out.println("Before set() call: " + advCms.get(5));
        advCms.set(5,aCourse);
        System.out.println("advCms.set(5,aCourse);");
        System.out.println("After set() call: " + advCms.get(5));
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 7 ***************************");
        System.out.println("Trying to set a disabled course to different values.");
        System.out.println("Before set() call: " + advCms.get(25));
        advCms.set(25,aCourse);
        System.out.println("advCms.set(5,aCourse);");
        System.out.println("After set() call: " + advCms.get(25));
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 8 ***************************");
        System.out.println("Disabled courses:");
        advCms.showDisabled();
        System.out.println("Size before enabling: " + advCms.size());
        advCms.enable("CSE 211");
        advCms.enable("CSE 232");
        advCms.enable("EN 112");
        System.out.println("        advCms.enable(\"CSE 211\");\n" +
                "        advCms.enable(\"CSE 232\");\n" +
                "        advCms.enable(\"EN 112\");");

        System.out.println("Size after enabling: " + advCms.size());
        advCms.showDisabled();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 9 ***************************");
        System.out.println("Removing by index, enabled item");
        System.out.println("First index before removal: " + advCms.get(1));
        advCms.remove(1);
        System.out.println("First index after removal: " + advCms.get(1));
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 10 ***************************");
        System.out.println("Trying to remove disabled item:");

        System.out.println("Disabling course at index 1 and trying to remove it.");
        System.out.println("        advCms.disable(1);\n" +
                "        advCms.showDisabled();");

        advCms.disable(1);
        advCms.showDisabled();
        advCms.remove(1);

        System.out.println("Enabling the course we tried to remove to see if it is still there. ");
        System.out.println("advCms.enable(1);");
        advCms.enable(1);

        System.out.println("First index after trying to remove: " + advCms.get(1));
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 11 ***************************");
        System.out.println("Creating an iterator from enabled item.");
        ListIterator<BasicCourse> litr = null;
        litr = advCms.listIterator(50);

        System.out.println("Traversing the list in forward direction:");
        while(litr.hasNext()){
            System.out.println(litr.next());
        }
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 12 ***************************");
        System.out.println("Trying to create an iterator from disabled item.");
        System.out.println("        ListIterator<BasicCourse> litrDis = null;\n" +
                "        advCms.disable(50);\n" +
                "        litrDis = advCms.listIterator(50);");
        ListIterator<BasicCourse> litrDis = null;
        advCms.disable(50);
        litrDis = advCms.listIterator(50);

        System.out.println("litrDis == null :" + (litrDis == null));

        System.out.println("******************************************************************");

        System.out.println("\n*************************** PART 3 ***************************");
        System.out.println("\n*************************** Scenario 1 ***************************");
        BasicCourse c1 = new BasicCourse("1","C1 XXX","Course One","1","1","1+0+0");
        BasicCourse c2 = new BasicCourse("1","C2 XXX","Course Two","2","2","2+0+0");
        BasicCourse c3 = new BasicCourse("2","C3 XXX","Course Three","3","3","3+0+0");
        BasicCourse c4 = new BasicCourse("2","C4 XXX","Course Four","4","4","4+0+0");
        BasicCourse c5 = new BasicCourse("2","C5 XXX","Course Five","5","5","5+0+0");

        System.out.println("Creating a new management system for courses.");
        part3CMS part3courses = new part3CMS();
        System.out.println("part3CMS part3courses = new part3CMS();");
        System.out.println("Adding courses");
        part3courses.add(c1);
        part3courses.add(c2);
        part3courses.add(c3);
        System.out.println("        part3courses.add(c1);\n" +
                "        part3courses.add(c2);\n" +
                "        part3courses.add(c3);");
        System.out.println("Printing courses:");
        part3courses.showCourses();
        System.out.println("******************************************************************");

        System.out.println("\n*************************** Scenario 2 ***************************");
        System.out.println("Removing and adding courses to the system we created in Scenario 1.");
        System.out.println("        part3courses.remove(1);\n" +
                "        part3courses.add(c4);\n" +
                "        part3courses.remove(2);\n" +
                "        part3courses.add(c5);\n" +
                "        part3courses.showCourses();");
        part3courses.remove(1);
        part3courses.add(c4);
        part3courses.remove(2);
        part3courses.add(c5);
        part3courses.showCourses();
        System.out.println("******************************************************************");
        System.out.println("\n*************************** Scenario 3 ***************************");
        System.out.println("Print and get size of the list after above operations.");
        part3courses.showCourses();
        System.out.println("Size: " + part3courses.size());
        System.out.println("******************************************************************");


    }



}
