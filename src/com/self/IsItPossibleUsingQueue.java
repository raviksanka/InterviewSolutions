package com.self;

import java.util.LinkedList;
import java.util.Queue;

// Check whether conversion of given array to new array via specified fashion is possible or not
public class IsItPossibleUsingQueue {

    // You are given a pair of integers (x,y) and need to be converted to (a,b).
    // You may perform either of the two operations below,in any order, zero or more times.
            // 1. (x,y) -> (x+y,y)
            // 2. (x,y) -> (x,y+x)
    static Queue<Integer[]> q = new LinkedList<>();

    public static String isItPossible(Integer a, Integer b, Integer c, Integer d) {
        q.add(new Integer[]{a, b});
        while (!q.isEmpty()) {
            Integer[] pair = q.remove();
            Integer key = pair[0];
            Integer value = pair[1];
            if (key.equals(c) && value.equals(d)) {
                return "YES";
            }
            int sum = key + value;
            if (sum <= c) {
                q.add(new Integer[]{sum, value});
            }
            if (sum <= d) {
                q.add(new Integer[]{key, sum});
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        System.out.println(isItPossible(1,2,3,2));
    }

}
