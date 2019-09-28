
/*
    The time complexity can be reduced by storing results of subproblems.
    We maintain a boolean table[n][n] that is filled in bottom up manner.
    The value of table[i][j] is true, if the substring is palindrome, otherwise false.
    To calculate table[i][j], we first check the value of table[i+1][j-1],
        if the value is true and str[i] is same as str[j], then we make table[i][j] true.
            Otherwise, the value of table[i][j] is made false.
    Time complexity: O ( n^2 )
    Auxiliary Space: O ( n^2 )
 */

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalSubstr("abcbd"));
    }

    // This function prints the longest palindrome substring of str.
    static String longestPalSubstr(String str) {

        int n = str.length();   // get length of input string
        // table[i][j] will be false if substring str[i..j] is not palindrome. Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // Check for lengths greater than 2. k is length of substring
        for (int k = 3; k <= n; ++k) {
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;
                // checking for sub-string from ith index to jth index
                //        if str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start, start + maxLength);
    }
}
