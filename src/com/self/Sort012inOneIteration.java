package com.self;

import java.util.Arrays;

// Sort 0's and 1's and 2's in one traversal
public class Sort012inOneIteration {

    // Binary sorting
    public static void sort012(int a[]) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    if(a[lo] != a[mid]) {
                        temp = a[lo];
                        a[lo] = a[mid];
                        a[mid] = temp;
                    }
                    lo++; mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    if(a[hi] != a[mid]) {
                        temp = a[mid];
                        a[mid] = a[hi];
                        a[hi] = temp;
                    }
                    hi--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String args[]) {
        sort012(new int[]{0, 1, 2, 1, 0, 2, 0});
    }

}
