package com.muhammedokumus;

public class Course {
    private int semester;
    private String courseCode;
    private String courseTitle;
    private int ectsCredit;
    private double gtuCredit;
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
    //SETTERS
    private void setSemester(int semester){ this.semester = semester; }

    private void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    private void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }

    private void setEctsCredit(int ectsCredit) { this.ectsCredit = ectsCredit; }

    private void setGtuCredit(double gtuCredit) { this.gtuCredit = gtuCredit; }

    private void setCreditWeight(String creditWeight) { this.creditWeight = creditWeight; }



    //GETTERS
    public int getSemester(){
        return semester;
    }

    public String getCourseCode(){ return courseCode; }

    public String getCourseTitle(){ return courseTitle; }

    public int getEctsCredit(){ return ectsCredit; }

    public double getGtuCredit() { return gtuCredit; }

    public String getCreditWeight() { return creditWeight; }
}
