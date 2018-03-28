package com.muhammedokumus;

import com.muhammedokumus.coursestructure.BasicCourse;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * (part 2)
 * This class implements enable(),disable() methods to use on a CourseManagementSystem object and overrides
 * methods in LinkedList to be switch on or off according to item being enabled or not.
 */
public class AdvancedCMS extends LinkedList<BasicCourse> {

    private CourseManagementSystem advancedCMS;
    private int size;

    //CONSTRUCTOR
    public AdvancedCMS(String filename){
        advancedCMS = new CourseManagementSystem(filename);
        size = advancedCMS.getCourses().size();
    }

    /**
     * Enables given item so AdvancedCSM methods are usable on the element again.
     * @param courseCode course (i.e: CSE 222) as string
     * @return 0 if item is already enabled, 1 if item is is successfully enabled.
     */
    public int enable(String courseCode){
        BasicCourse item = advancedCMS.get(courseCode);
        return enableWrap(item);
    }

    /**
     * Enables the item at given index, so AdvancedCSM methods are usable on the element again.
     * @param courseIndex course index
     * @return 0 if item is already enabled, 1 if item is is successfully enabled.
     */
    public int enable(int courseIndex){
        BasicCourse item = advancedCMS.get(courseIndex);
        return enableWrap(item);
    }

    private int enableWrap(BasicCourse item) {
        if(item.isAccessable() == true){
            System.out.println("Item is already enabled.");
            return 0;
        }
        else{
            item.setAccessible(true);
            size++;
            return 1;
        }
    }

    /**
     * Disables given item, prevents AdvancedCSM methods from using on that item.
     * @param courseCode course (i.e: CSE 222) as string
     * @return 0 if item is already disabled, 1 if item is is successfully disabled.
     */
    public int disable(String courseCode){
        BasicCourse item = advancedCMS.get(courseCode);
        return disableWrap(item);
    }

    /**
     * Disables the item at given index, prevents AdvancedCSM methods from using on that item.
     * @param courseIndex course index
     * @return 0 if item is already disabled, 1 if item is is successfully disabled.
     */
    public int disable(int courseIndex){
        BasicCourse item = advancedCMS.get(courseIndex);
        return disableWrap(item);
    }

    private int disableWrap(BasicCourse item) {
        if(item.isAccessable() == false){
            System.out.println("Item is already disabled");
            return 0;
        }
        else{
            item.setAccessible(false);
            size--;
            return 1;
        }
    }

    /**
     * Prints disabled courses in the calling CSM class.
     * @return number of disabled courses. 0 if none.
     */
    public int showDisabled(){
        int numOfDisabledCourses = 0;
        for(BasicCourse item : advancedCMS.getCourses()){
            if(item.isAccessable() == false){
                System.out.println((numOfDisabledCourses+1) + ") " + item);
                numOfDisabledCourses++;
            }
        }
        if(numOfDisabledCourses == 0)
            System.out.println("There are no disabled courses");

        return numOfDisabledCourses;
    }

    /**
     * Gets the course reference at given index.
     * @param index
     * @return course at given index, or null if course is disabled
     */
    public BasicCourse get(int index){
        if(advancedCMS.get(index).isAccessable() == true)
            return advancedCMS.get(index);
        else{
            System.out.println("You are trying to access a disabled element.");
            return null;
        }

    }

    /**
     * Gets the course reference with the given course code.
     * pre: Not an optional course with code "XXX XXX".
     * @param courseCode course (i.e: CSE 222) as string
     * @return course with the given course code, or null if course is disabled
     */
    public BasicCourse get(String courseCode){
        if(advancedCMS.get(courseCode).isAccessable() == true)
            return advancedCMS.get(courseCode);
        else{
            System.out.println("You are trying to access a disabled element.");
            return null;
        }
    }

    /**
     *
     * @param index index to be set
     * @param element element to be assigned
     * @return the element previously at the specified position
     */
    public BasicCourse set(int index, BasicCourse element){
        if(advancedCMS.get(index).isAccessable() == true){
            BasicCourse courseToBeReplaced = advancedCMS.get(index);
            advancedCMS.get(index).setCourse(element.getSemester(),
                    element.getCourseCode(),
                    element.getCourseTitle(),
                    element.getEctsCredit(),
                    element.getGtuCredit(),
                    element.getCreditWeight(),
                    element.isAccessable());

            return courseToBeReplaced;
        }

        return null;
    }

    /**
     * Gives size of the cms system.
     * @return Size, excluding the disabled elements.
     */
    public int size(){
        return size;
    }

    /**
     * Removes element at the given index.
     * @param index to be removed
     * @return removed element.
     */

    public BasicCourse remove(int index){
        if(advancedCMS.get(index).isAccessable() == true){
            return advancedCMS.getCourses().remove(index);
        }
        return null;
    }

    /**
     * Gives an iterator to specified item's index.
     * @param index to set Iterator position
     * @return null if item is disabled, or iterator object to given index.
     */
    public ListIterator<BasicCourse> listIterator(int index){
        if(advancedCMS.get(index).isAccessable() == true){
            return advancedCMS.getCourses().listIterator(index);
        }
        return null;
    }
}
