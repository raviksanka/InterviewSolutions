package com.self;

import javafx.util.Pair;

import java.util.LinkedList;

// Check whether conversion of given array to new array via specified fashion is possible or not
public class IsItPossibleForConversion {

    // You are given a pair of integers (x,y) and need to be converted to (a,b).
    // You may perform either of the two operations below,in any order, zero or more times.
            // 1. (x,y) -> (x+y,y)
            // 2. (x,y) -> (x,y+x)
    static LinkedList<Pair<Integer, Integer>> pairs = new LinkedList<>();

    public static String isItPossible(Integer a, Integer b, Integer c, Integer d) {
        pairs.addLast(new Pair<>(a, b));
        while (!pairs.isEmpty()) {
            Pair<Integer, Integer> pair = pairs.poll();
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            if (key.equals(c) && value.equals(d)) {
                return "YES";
            }
            int sum = key + value;
            if (sum <= c) {
                pairs.addLast(new Pair<>(sum, value));
            }
            if (sum <= d) {
                pairs.addLast(new Pair<>(key, sum));
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        System.out.println(isItPossible(1,2,3,4));
    }

}
