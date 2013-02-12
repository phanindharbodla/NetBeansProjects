package com.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllowableChars {
  public static void main(String args[]) { // removes numbers appended with # following characters..!!
    String regex = "[^[#&[0-9]*]]";
    Pattern pattern = Pattern.compile(regex);
    String candidate = "asd5#123: ads";
    Matcher matcher = pattern.matcher(candidate);
    String temp=matcher.replaceAll("");
    System.out.println("ORIGINAL: " + candidate);
    System.out.println("REPLACEMENT: " + temp);
  }
}