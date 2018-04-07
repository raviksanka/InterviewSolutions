package com.self;

import java.util.Scanner;

/**
 * Problem Statement: We are thinking of an integer P within the range (A,B] — that is, A < P ≤ B.
 *      You have N tries to guess our number. After each guess that is not correct,
 *          we will tell you whether P is higher or lower than your guess.
 */
public class NumberGuessing {

    private static void solve(Scanner input, int a, int b) {

        int m = (a + b) / 2;
        System.out.println(m);
        String s = input.next();
        if ("CORRECT".equalsIgnoreCase(s)) {
            return;
        } else if ("TOO_SMALL".equalsIgnoreCase(s)) {
            solve(input, m + 1, b);
        } else {
            solve(input, a, m - 1);
        }
    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int a = input.nextInt();
            int b = input.nextInt();
            solve(input, a + 1, b);
        }
    }
}