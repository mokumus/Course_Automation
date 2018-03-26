package com.muhammedokumus.coursestructure;

/**
 * This class is used for adding new properties and methods to manipulate course access.
 */
public class ExtendedCourse extends Course {
    private boolean isAccessable = true;

    public ExtendedCourse(){
        super();
        isAccessable = true;
    }
    public ExtendedCourse(String semester, String courseCode, String courseTitle, String ectsCredit, String gtuCredit, String creditWeight){
        super(semester,courseCode,courseTitle,ectsCredit,gtuCredit,creditWeight);
        isAccessable = true;
    }

    public void setAccessible(boolean isAccessable) { this.isAccessable = isAccessable; }

    public boolean isAccessable() { return isAccessable; }
}
