package com.self;

// Given an array of N integers, 
//  find the length of the longest subsequence of a given sequence such that
//     all elements of the subsequence are sorted in strictly decreasing order.

class LonDecSubSeq {

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {15, 27, 14, 38, 63, 55, 46, 65, 85};
        int n = arr.length;
        System.out.print("Length of LDS is " + lds(arr, n));
    }

    // Function that returns the length of the longest decreasing subsequence
    static int lds(int arr[], int n) {

        int lds[] = new int[n];
        int i, j, max = 0;
        // Initialize LDS with 1 for all index.
        // The minimum LDS starting with any element is always 1.
        for (i = 0; i < n; i++)
            lds[i] = 1;

        // Compute LDS from every index in bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] < arr[j] &&
                        lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;

        // Select the maximum of all the LDS values
        for (i = 0; i < n; i++)
            if (max < lds[i])
                max = lds[i];

        // returns the length of the LDS
        return max;
    }

}
