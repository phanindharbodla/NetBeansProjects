package com.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllowableChars {
  public static void main(String args[]) {
    String regex = "[^-.0-9]";

    Pattern pattern = Pattern.compile(regex);

    String candidate = "-10.wer45";

    Matcher matcher = pattern.matcher(candidate);
    String temp=matcher.replaceAll("");
    
    System.out.println("ORIGINAL: " + candidate);
    System.out.println("REPLACEMENT: " + temp);
  }
}