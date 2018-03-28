package com.muhammedokumus;


import com.muhammedokumus.coursestructure.BasicCourse;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Class to handle tasks about course data access.(part 1)
 */
public class CourseManagementSystem {
   private LinkedList<BasicCourse> courses = new LinkedList<>();
   public final int MAX_SEMS = 8;

    /**
     * pre: A csv formatted file with 6 values each line.
     * post: A management system object filled with courses in given file
     * @param filename file path to csv file
     */
   public CourseManagementSystem(String filename) {
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


   protected LinkedList<BasicCourse> getCourses(){
       return courses;
   }

    /**
     * Prints courses in the given semester.
     * @param semester 1 to X depending on program of the university, x = MAX_SEMS
     * @return 0 if semester value is out of range, 1 if printed successfully
     */
    public int listSemesterCourses(int semester){
       if (semester < 1 || semester > MAX_SEMS){
           System.out.println("There is no " + semester + ". semester in the program.");
           return 0;
       }
       else{
           System.out.println("************************************************************************************************************");
           System.out.println(semester + ". Semester Courses");
           for(BasicCourse item : courses){
               if(Integer.toString(semester).equals(item.getSemester()))
                   System.out.println(item);
           }
           System.out.println("************************************************************************************************************");
           return 1;
       }
    }

    /**
     * Prints courses in the given range of semesters.
     * @param startIndex starting semester, included
     * @param lastIndex ending semester, included
     * @return 0 if range is invalid, 1 if printed successfully
     */
    public int getByRange(int startIndex, int lastIndex){
        if(startIndex > lastIndex){
            System.out.println("Starting semester value cannot be bigger than ending value.");
            return 0;
        }

        else if(startIndex <= 0 || lastIndex > MAX_SEMS){
            System.out.println("Semesters out of range.");
            return 0;
        }
        else{
            System.out.println("Courses between " + startIndex + ". and " + lastIndex + ". semesters.");
            for(int i = startIndex; i <= lastIndex; i++)
                listSemesterCourses(i);

            return 1;
        }
    }

    /**
     * Prints the courses with the matching course code.
     * @param code code of the course
     * @return 0 if no items found, 1 if printed successfully
     */
    public int getByCode(String code){
        int found = 0;

        for(BasicCourse item : courses){
            if(code.equals(item.getCourseCode())){
                System.out.println(item);
                found = 1;
            }
        }

        if(found == 0)
            System.out.println("No courses found with that code.");

        return found;
    }

    /**
     *
     * @param code code of the course
     * @return Course object reference
     */
    public BasicCourse get(String code){
        if(code.equals("XXX XXX"))
            throw new IllegalArgumentException("Optional courses are only available to edit by indexes.");

        for(BasicCourse item : courses){
            if(code.equals(item.getCourseCode())){
                return item;
            }
        }
        throw new NoSuchElementException("Item not found. Code : " + code);
    }

    /**
     *
     * @param courseIndex index of the course
     * @return Course object reference
     */
    public BasicCourse get(int courseIndex){
        return courses.get(courseIndex);
    }


}
