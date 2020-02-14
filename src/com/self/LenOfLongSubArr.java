package com.self;


/**
 * Find out the longest length of subarray with at most 2 different numbers.
 * Explanation:
 * Loop all numbers c in array/list, Note that a and b are the last two different types of numbers that we met,
 * c is the current number, so it's something like "....aaabbbc..."
 *
 * Case 1 c == b:
 * number c already in the subarray, and it's same as the last number.
 * cur += 1, count_b += 1
 *
 * Case 2 c == a:
 * number c already in the subarray, but it's not same as the last number.
 * cur += 1, count_b = 1, a = b, b = c
 *
 * Case 3 c != b && c!= a:
 * number c not in the subarray,
 * cur = count_b + 1, count_b = 1, a = b, b = c
 *
 * Of course, in each turn we need to update res = max(res, cur)
 *
 * Complexity:
 * O(N) time, O(1) space
 */
public class LenOfLongSubArr {

    public static void main(String[] args) {
        System.out.println(longestArraySize(new int[] {1,2,3,3,4,5,5,6,6,7,7,8}));
    }

    public static int longestArraySize(int[] inputArray) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  inputArray) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
}
