package com.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveZero {

    public static void main(String args[]) { // removes numbers appended with # following characters..!!
        String re1 = "(\\+)";	// Any Single Character 1
        String re2 = "(\\s+)";	// White Space 1
        String re3 = "(0)";	// Any Single Character 2
        String re4 = "( )";	// White Space 2
        String re5 = "[^!]*";   //any word without !!
        Pattern pattern = Pattern.compile(re1 + re2 + re3 + re4 + re5, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        String candidate = "  + 0.8 WgtByDfu.O_NE_FLX_1_PBOKGX_2988663.2012m02m01.2012m02m01(C1)#4";
        Matcher matcher = pattern.matcher(candidate);
        String temp = matcher.replaceAll("");
        System.out.println("ORIGINAL:    " + candidate);
        System.out.println("REPLACEMENT: " + temp);
    }
}