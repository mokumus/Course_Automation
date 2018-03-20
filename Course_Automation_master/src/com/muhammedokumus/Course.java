package com.muhammedokumus;

public class Course {
    private int semester;
    private String courseCode;
    private String courseTitle;
    private int ectsCredit;
    private int gtuCredit;
    private String creditWeight;

    public Course(){
        this(-1,null,null,-1,-1,null);
    }

    public Course(int semester, String courseCode, String courseTitle, int ectsCredit, int gtuCredit, String creditWeight){
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.ectsCredit = ectsCredit;
        this.gtuCredit = gtuCredit;
        this.creditWeight = creditWeight;
    }

    @Override
    public String toString(){
        return "Course[" +
                "semester=" + semester + ", " +
                "code=" + courseCode + ", " +
                "title=" + courseTitle + ", " +
                "ects=" + ectsCredit + ", " +
                "gtu=" + gtuCredit + ", " +
                "T+U+L=" + creditWeight +
                "]";
    }

    public void setSemester(int semester){
        this.semester = semester;
    }

    public int getSemester(){
        return semester;
    }



}
