package com.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllowableChars {
  public static void main(String args[]) {
    String regex = "[^-.0-9]";
    Pattern pattern = Pattern.compile(regex);
    regex = "[^#&&[0-9]]";
    Pattern pattern1 = Pattern.compile(regex);
    String candidate = "-10.wer45";
    Matcher matcher = pattern.matcher(candidate);
    String temp=matcher.replaceAll("");
    System.out.println("ORIGINAL: " + candidate);
    System.out.println("REPLACEMENT: " + temp);
    String candidate1 = "man#10 "+"a";
    regex = "[#]";
    Pattern pattern2 = Pattern.compile(regex);
    matcher = pattern1.matcher(candidate1);
    temp=matcher.replaceAll("");
    System.out.println("ORIGINAL: " + candidate1);
    System.out.println("REPLACEMENT: " + temp);
    matcher = pattern2.matcher(temp);
    String temp1=matcher.replaceAll("");
    System.out.println("ORIGINAL: " + temp);
    System.out.println("REPLACEMENT: " + temp1);
  }
}