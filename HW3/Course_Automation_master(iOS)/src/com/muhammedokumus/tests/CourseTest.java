package com.muhammedokumus.tests;

import com.muhammedokumus.coursestructure.BasicCourse;
import org.junit.jupiter.api.Test;

class CourseTest {


    @Test
    public void constructionTest() {
        //Course course1 = new Course(1, "CSE 222", "Data Structures and Algorithims", 8, 6,"5+0+0");
        //System.out.println(course1);


        BasicCourse emptyCourse = new BasicCourse();
        System.out.println(emptyCourse);
    }

}