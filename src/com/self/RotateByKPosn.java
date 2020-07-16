package com.self;

/*
Write a Java program to rotate an array by K positions.
    If Arr[] = {1, 2, 3, 4, 5, 6} N=6 & K=2 then rotated array will be {5, 6, 1, 2, 3, 4}
 */
public class RotateByKPosn {
    // We can solve this in O(n) time and O(1) extra space.
    //  The idea is to reverse last ‘k’ elements of the input array and then reverse the remaining ‘n-k’ elements.
    //      Finally, we can get the right rotated array by reversing the complete array.

    public static void main(String[] args) {
        rotate(new int[]{ 1, 2, 3, 4, 5, 6, 7 }, 3);
    }

    public static void rotate(int[] arr, int order) {
        
        if (arr == null || arr.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        if(order > arr.length) {
            order = order % arr.length;
        }
        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    public static void reverse(int[] arr, int left, int right) {
        
        if(arr == null || arr.length == 1)
            return;

        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
}
