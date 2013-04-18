/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Phanindhar Bodla
 */
public class GuavaTest {
    public static void main(String args[])
    {
        BiMap<Integer, String> bimap = HashBiMap.create();
        
        Map <Object ,C > B =new HashMap<Object, C>();
        Map <Object ,B > A =new HashMap<Object, B>();
        Map <A ,B > Map =new HashMap<A, B>();
        //Map i=new HashMap();
        bimap.put(121, "string");
        bimap.put(123, "strn2g");
        bimap.put(123, "rng123");
        
    }

    private static class C {

        public C() {
            Map <Object ,String> ObjectC =new HashMap<Object, String>();
        }
    }

    private static class B {

        public B() {
            Map <Object ,C> ObjectB =new HashMap<Object, C>();
        }
    }

    private static class A {

        public A() {
            Map <Object ,B> ObjectA =new HashMap<Object, B>();
        }
    }

}
