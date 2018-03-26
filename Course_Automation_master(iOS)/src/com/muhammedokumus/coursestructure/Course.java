package com.muhammedokumus.coursestructure;

public class Course implements CourseInterface{
    private String semester;
    private String courseCode;
    private String courseTitle;
    private String ectsCredit;
    private String gtuCredit;
    private String creditWeight;


    public Course(){
        this(null,null,null,null,null,null);
    }

    public Course(String semester, String courseCode, String courseTitle, String ectsCredit, String gtuCredit, String creditWeight){
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
    public void setSemester(String semester){ this.semester = semester; }

    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }

    public void setEctsCredit(String ectsCredit) { this.ectsCredit = ectsCredit; }

    public void setGtuCredit(String gtuCredit) { this.gtuCredit = gtuCredit; }

    public void setCreditWeight(String creditWeight) { this.creditWeight = creditWeight; }



    //GETTERS
    public String getSemester(){
        return semester;
    }

    public String getCourseCode(){ return courseCode; }

    public String getCourseTitle(){ return courseTitle; }

    public String getEctsCredit(){ return ectsCredit; }

    public String getGtuCredit() { return gtuCredit; }

    public String getCreditWeight() { return creditWeight; }


}
