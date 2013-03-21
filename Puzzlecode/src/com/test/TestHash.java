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
public class TestHash {

    public static class CrossMap {

        Map IndexAsKey;
        Map ValueAsKey;

        void CrossMap() {
            this.IndexAsKey = new HashMap();
            this.ValueAsKey = new HashMap();
        }

        void put(Object index, Object value) {
            this.IndexAsKey.put(index, value);
            this.ValueAsKey.put(value, index);
        }

        Object getValue(Object key) {
            return this.IndexAsKey.get(key);
        }

        Object getIndex(Object key) {
            return this.ValueAsKey.get(key);
        }
    }

    public static void main(String args[]) {
        CrossMap temp = new CrossMap();
        temp.put(10, 15);
        temp.getIndex(15);
        temp.getValue(10);
        temp.put(12, 10);
    }
}
