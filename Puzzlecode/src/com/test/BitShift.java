/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

/**
 *
 * @author Phanindhar Bodla
 */
public class BitShift {
    public static void main(String args[])
    {
        int a=12312,b=31,c,df=0XFFFFFFFF;
        c=(a<<31-b>>31-b);
        df=((1<<b)-1);
        c=a&df;
    }

}
