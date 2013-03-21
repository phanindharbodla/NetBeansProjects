/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Phanindhar Bodla
 */
public class HashCode {
    public static void main(String args[]){
        Map BeanMap= new HashMap();
        DfuBean prev=new DfuBean();
        prev.setDfuId("temp");
        prev.setStartDate("FEB-13-2012");
        prev.setBaseDemand(12.12910239);
        prev.setDmdType("Monday");
        prev.setLocation("India");
        prev.setDmdUnit("ValueAdded");
        BeanMap.put(prev, prev);
        DfuBean now = new DfuBean();
        now.setDfuId("temp");
        now.setStartDate("FEB-13-2012");
        System.out.println(prev+"       "+now);
        now=(DfuBean) BeanMap.get(now);
        double a=now.getBaseDemand();
        System.out.println(prev.hashCode()+"       "+now.hashCode());
        System.out.println(now+" "+prev+" "+a);
        System.out.println("So now we cane surely say 2 things..!!");
        System.out.println("1)The Objects with Same hash values may not be equal..!!!");
        System.out.println("2)The Unequal Objects may have same hash code ........!!!");
        System.out.println("3)So this trick helps giving better way to hash.......!!!");
        System.out.println("4)We now create the hashcode of the Object we want....!!!");
        System.out.println("5)We now just had the hashcode of our desired object but not Object........!!!");
        System.out.println("6)So if we has Mapped prev object with its hashcode we can get it now as we know its key or hashcode ........!!!");
        System.out.println("7)All we need to do is maintain a static HashMap of our Bean Class.........!!!");
        System.out.println("8)The Hashcode is to be used as key only when you have a perfect HashFunction else collision is possible like a unique key generator........!!!");
        System.out.println("9)The Hashcode is to be used when the keys used to generate hash are constant like you need to remove the entry and recreate them when you update the primarykeys used for hash function ........!!!");
    }

}
