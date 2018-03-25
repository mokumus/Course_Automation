package com.muhammedokumus;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for csv file reading.
 */
public class CSV_Utils {
    private final List<String[]> listOfRows = new ArrayList<>();

    /**
     * pre: A csv formatted file with values splitted by ';'
     * post: A list of String arrays, each String array is made of corresponding line of file.
     * @param filename  file path.
     * @return List of string arrays.
     */
    public List<String[]> csvFileToListOfStrings(String filename){
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                listOfRows.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Please check Files folder under project for users.csv");
        } catch (IOException e) {
            System.out.println("User data could not be loaded. File format is wrong/corrupted.");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOfRows;
    }
}
