package com.muhammedokumus.tests;

import com.muhammedokumus.AdvancedCMS;
import com.muhammedokumus.coursestructure.BasicCourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedCMSTest {

    AdvancedCMS  advCms = new AdvancedCMS("Files/Courses.csv");



    @Test
    void enableAndDisableTest() {
        System.out.println("Trying to enable already enabled course by course code.");
        assertEquals(0,advCms.enable("CSE 222"));

        System.out.println("\nTrying to enable already enabled course by course index.");
        assertEquals(0,advCms.enable(10));

        System.out.println("\nTrying to disable already enabled course by course code.");
        assertEquals(1,advCms.disable("CSE 222"));

        System.out.println("Trying to disable already enabled course by course index");
        assertEquals(1,advCms.disable(10));

        System.out.println("\nShowing disabled courses by showDisabled() method.");
        advCms.showDisabled();

        System.out.println("\nEnabling above disabled courses");
        assertEquals(1,advCms.enable("CSE 102"));
        assertEquals(1,advCms.enable("CSE 222"));

        System.out.println("\nShowing disabled course after enabling all disabled courses.");
        advCms.showDisabled();
    }


}