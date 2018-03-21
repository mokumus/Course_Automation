package com.muhammedokumus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSV_UtilsTest {

    @org.junit.jupiter.api.Test
    public void csvFileToListOfStrings() {
        String filename = "Files/Courses.csv";

        CSV_Utils usersFile = new CSV_Utils();
        List<String[]> rawUserData;

        rawUserData = usersFile.csvFileToListOfStrings(filename);

        System.out.println("Checking if for number of fields.Course Code,Title etc.");
        assertEquals(6, rawUserData.get(0).length);

        System.out.println("Checking if number of lines read is correct.");
        assertEquals(55,rawUserData.size());

        System.out.println("Checking if reading the file correctly for the first line");
        String[] expectedString1 = new String[] { "Semester","Course Code","Course Title","ECTS Credits","GTU Credits","H+T+L" };
        assertEquals(Arrays.toString(expectedString1),Arrays.toString(rawUserData.get(0)));

        System.out.println("Checking if reading the file correctly for the last line");
        String[] expectedString2 = new String[] { "8","XXX XXX","Teknik Olmayan Seçmeli (SSA)","3","2","2+0+0" };
        assertEquals(Arrays.toString(expectedString2),Arrays.toString(rawUserData.get(54)));
    }
}