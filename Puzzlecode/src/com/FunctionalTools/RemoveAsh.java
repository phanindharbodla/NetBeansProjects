/*
 * This is a java tool which just remove the [0-9] digits next to # from a given file and generates the new file
 * Give the location of the files..
 */
package com.FunctionalTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Phanindhar Bodla
 */
public class RemoveAsh {

    public static void main(String args[]) {
        try {
            File inputFile = new File("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\FunctionalTools\\temp.lp");//Give your lp file name here in " "
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String strLine;
            BufferedWriter outputFile = new BufferedWriter(new FileWriter("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\FunctionalTools\\test.lp"));//the test.lp is your output file
            while ((strLine = br.readLine()) != null) {
                strLine = process(strLine);
                outputFile.write(strLine);
                outputFile.newLine();
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private static String process(String strLine) {
        String line = "";
        int j = strLine.length();
        try {
            if (j != 0) {
                for (int i = 0; i < j; i++) {
                    if (strLine.charAt(i) == '#') {
                        i++;
                        while (strLine.charAt(i) <='9' && strLine.charAt(i) >= '0') {
                            i++;
                        }
                        line = line + strLine.charAt(i);
                    } else {
                        line = line + strLine.charAt(i);
                    }
                }
            }
        } catch (Exception e) {
        }
       return line;
    }
}