package com.test;

/**
 *
 * @author Phanindhar Bodla
 */
public class Casting {
    public static void main(String args[])
    {
    int i=10;
    String s ="key";
    String d ="key";
    d=d.toUpperCase();
    System.out.println(s);
    System.out.println(d);
    Object m =i ;
    Object n =s ;
    i=(Integer)m;
    s=(String)n;
    System.out.println(i);
    System.out.println(s);
}

}
