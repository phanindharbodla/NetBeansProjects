/*
 * Give the code of load query string in code.txt get 
 * query at query .txt
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
public class CodeToQuery {

    public static void main(String args[]) {
        try {
            File inputFile = new File("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\FunctionalTools\\loadquery.txt");//Give your input load query ..
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String strLine;
            BufferedWriter outputFile = new BufferedWriter(new FileWriter("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\FunctionalTools\\query.txt"));//the query .text.txt is your output file
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
         {
            if (j != 0) {
                for (int i = 0; i < j; i++) {
                    if (strLine.charAt(i) == '"') {
                        i++;
                        while (strLine.charAt(i) != '"') {
                            line = line + strLine.charAt(i);
                            i++;
                        }
                    }
                }
            }
        } 
        return line;
    }
}
