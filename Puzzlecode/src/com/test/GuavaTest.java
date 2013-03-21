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
        Map i=new HashMap();
        bimap.put(121, "string");
        bimap.put(123, "strn2g");
        bimap.put(123, "rng123");
        
    }

}
