package com.self;

// Minimum insertions to form a palindrome
public class MinInsertToMakePalindrome {
// Approach 1: Recursive Approach: The minimum number of insertions in the string str[l…..h] can be given as:
    //      minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
    //      min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise
    //          But this results in overlapping subproblems like for "abcde".
    //          We can avoid this by Memoization technique

    // Approach 2: A Java solution for Dynamic Programming based program
    // to find minimum number insertions needed to make a string palindrome.
    static int findMinInsertionsDP(char str[], int n) {
        // Create a table of size n*n.
        //  table[i][j] will store minimum number of insertions needed to convert str[i..j] to palindrome.
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h])
                        ? table[l + 1][h - 1]
                        : (Integer.min(table[l][h - 1], table[l + 1][h]) + 1);

        // Return minimum number of insertions for str[0..n-1]
        return table[0][n - 1];
    }

    // Driver program to test above function.
    public static void main(String args[]) {
        String str = "geeks";
        System.out.println(findMinInsertionsDP(str.toCharArray(), str.length()));
    }

}
