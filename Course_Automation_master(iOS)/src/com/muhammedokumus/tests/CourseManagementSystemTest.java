package com.muhammedokumus.tests;

import com.muhammedokumus.CourseManagementSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseManagementSystemTest {
    CourseManagementSystem cms = new CourseManagementSystem("Files/Courses.csv");


    void listSemesterCoursesTest() {
        System.out.println("Testing for unexisting semester values.");

        assertEquals(0,cms.listSemesterCourses(-1));
        assertEquals(0,cms.listSemesterCourses(0));
        assertEquals(0,cms.listSemesterCourses(9));

        System.out.println("\nTesting for existing semester values.");

        assertEquals(1,cms.listSemesterCourses(1));
        assertEquals(1,cms.listSemesterCourses(4));
        assertEquals(1,cms.listSemesterCourses(8));

    }



    void getByRangeTest(){
        System.out.println("Testing for invalid semester ranges.");

        assertEquals(0, cms.getByRange(-1,5));
        assertEquals(0, cms.getByRange(0,0));
        assertEquals(0, cms.getByRange(3,9));

        System.out.println("\nTesting for valid semester ranges.");

        assertEquals(1, cms.getByRange(1,3));
        assertEquals(1, cms.getByRange(2,2));
        assertEquals(1, cms.getByRange(7,8));
    }

    @Test
    void getByCodeTest(){
        System.out.println("Testing for invalid course code");
        assertEquals(0,cms.getByCode("MAT 202"));

        System.out.println("\nTesting for valid course code");
        assertEquals(1,cms.getByCode("CSE 107"));
    }


}