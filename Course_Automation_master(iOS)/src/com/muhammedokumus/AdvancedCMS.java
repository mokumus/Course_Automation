package com.muhammedokumus;

import com.muhammedokumus.coursestructure.Course;
import com.muhammedokumus.coursestructure.ExtendedCourse;

import java.util.LinkedList;
import java.util.ListIterator;

public class AdvancedCMS extends LinkedList<ExtendedCourse>{

    CourseManagementSystem advancedCMS;
    int size;

    public AdvancedCMS(String filename){
        advancedCMS = new CourseManagementSystem(filename);
        size = advancedCMS.getCourses().size();
    }

    public int enable(ExtendedCourse item){
        item.setAccessible(true);
        size++;
        return 1;
    }

    public int disable(ExtendedCourse item){
        item.setAccessible(false);
        size--;
        return 1;
    }

    public int showDisabled(){

        return 1;
    }

    public ExtendedCourse get(int index){
        //code here
        return null;
    }

    public ExtendedCourse set(int index, Course element){
        //code here
        return null;
    }

    public int size(){
        //code here
        return 0;
    }

    public ExtendedCourse remove(int index){
        //code her;
        return null;
    }

    public boolean remove(Object o){
        //code her;
        return false;
    }

    public ListIterator<ExtendedCourse> listIterator(int index){
        //code here;
        return null;
    }
}
