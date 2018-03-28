package com.muhammedokumus.coursestructure;

public interface Course {
    void setSemester(String semester);

    void setCourseCode(String courseCode);

    void setCourseTitle(String courseTitle);

    void setEctsCredit(String ectsCredit);

    void setGtuCredit(String gtuCredit);

    void setCreditWeight(String creditWeight);


    String getSemester();

    String getCourseCode();

    String getCourseTitle();

    String getEctsCredit();

    String getGtuCredit();

    String getCreditWeight();

}
