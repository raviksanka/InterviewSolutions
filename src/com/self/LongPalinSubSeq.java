package com.self;

// Given a sequence, find the length of the longest palindromic subsequence in it.

public class LongPalinSubSeq {
  
  public static void main(String[] args) {
        System.out.println(lps("abcde"));
  }
  
  static int lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        int[][] L = new int[n][n];

        for (i = 0; i < n; i++) {
            L[i][i] = 1;
        }
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                boolean b = (seq.charAt(i) == seq.charAt(j));
                if (b && cl == 2) {
                    L[i][j] = 2;
                } else if (b) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
                }
            }
        }
        return L[0][n - 1];
    }
  
}
