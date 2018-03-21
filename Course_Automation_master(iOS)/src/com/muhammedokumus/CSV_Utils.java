package com.muhammedokumus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV_Utils {
    private final List<String[]> listOfRows = new ArrayList<>();

    /**
     * Takes an input file formatted as a csv, puts each line of file to a List of Strings.
     * @param filename
     * File adress.
     * @return
     * Strings separated my comas, 1 entry for each line
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
