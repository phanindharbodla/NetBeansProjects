package com.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllowableChars {
  public static void main(String args[]) { // removes numbers appended with # following characters..!!
    String temp1,temp2,regex = "[^[#&[0-9]*]]";
    Pattern pattern = Pattern.compile(regex);
    String candidate = "asd5#123: ads";
    Matcher matcher = pattern.matcher(candidate);
    String temp=matcher.replaceAll("");
    System.out.println("ORIGINAL: " + candidate);
    System.out.println("REPLACEMENT: " + temp);
    temp1="C:\\Users\\j1013563\\Desktop\\VTune_Amplifier_XE_2013_update5_setup.exe";
    temp2="C:\\Users\\j1013563\\Desktop";
    temp=temp1.substring(temp2.length()+1, temp1.length());
    System.out.println("REPLACEMENT: " + temp);
  }
}