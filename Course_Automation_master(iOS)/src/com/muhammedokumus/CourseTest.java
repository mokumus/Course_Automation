package com.muhammedokumus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {


    @Test
    public void constructionTest() {
        Course course1 = new Course(1, "CSE 222", "Data Structures and Algorithims", 8, 6,"5+0+0");
        System.out.println(course1);


        Course emptyCourse = new Course();
        System.out.println(emptyCourse);

    }

}