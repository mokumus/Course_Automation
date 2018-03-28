package com.muhammedokumus.part3;

import com.muhammedokumus.CSV_Utils;
import com.muhammedokumus.coursestructure.BasicCourse;
import java.util.List;

/**
 * part3
 */
public class part3CMS {
    MyLinkedList<BasicCourse> courses = new MyLinkedList<>();
    public final int MAX_SEMS = 8;

    public part3CMS(){
        //LEFT EMPTY
    }

    public part3CMS(String filename) {
        initCourses(filename);
    }

    protected void initCourses(String filename){
        CSV_Utils coursesFile = new CSV_Utils();
        List<String[]> rawCourseData;
        rawCourseData = coursesFile.csvFileToListOfStrings(filename);

        for (String[] item : rawCourseData) {
            BasicCourse currentLine = new BasicCourse(item[0], item[1], item[2], item[3], item[4], item[5]);
            courses.add(currentLine);
        }
    }


    public MyLinkedList<BasicCourse> getCourses() {
        return courses;
    }

    public void add(BasicCourse item){
        courses.add(item);
    }

    public boolean remove(int index){
        return courses.remove(index);
    }

    public int size(){
        return courses.size();
    }


    public void showCourses(){
        courses.printList();
    }

}
