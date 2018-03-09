package com.self;

/*
 * This class is used to check what changes needs to be done 
 *        (like add, delete or swap) to make the 2 passed in strings to be same.
 */
public class CheckStringChange {
	
	public static void main(String[] args) {
		
		System.out.println(solution("a","ab"));
	}
    
    public static String solution(String S, String T) {
    	
        if (S == null && T == null) {
            return "NOTHING";
        }
        if ((S == null && T.length() > 1) || (T == null && S.length() > 1)) {
            return "IMPOSSIBLE";
        }
        if (S == null && T.length() == 1) {
            return "INSERT " + T;
        }
        if (T == null && S.length() == 1) {
            return "DELETE " + S;
        }
        if (S.equals(T)) {
            return "NOTHING";
        }
        String result = checkInsertCondition(S, T);
        if (null != result) {
            return "INSERT " + result;
        }
        result = checkDeleteCondition(S, T);
        if (null != result) {
            return "DELETE " + result;
        }
        result = checkSwapCondition(S, T);
        if (null != result) {
            return "SWAP " + result;
        }
        return "IMPOSSIBLE";
    }
    
    public static String checkInsertCondition(final String s1, final String s2) {
        
        if (s1.length() + 1 != s2.length()) {
            return null;
        }
        final char[] s1AsChrArr = s1.toCharArray();
        final char[] s2AsChrArr = s2.toCharArray();
        for (int s2ChrIdx = 0; s2ChrIdx < s2AsChrArr.length; s2ChrIdx++) {
            if (s2ChrIdx == s2AsChrArr.length - 1) { //deal with corner case, at last char in s2
                final String s1WthChrInsert = s1 + s2AsChrArr[s2ChrIdx];
                if (s1WthChrInsert.equals(s2)) {
                  return String.valueOf(s2AsChrArr[s2ChrIdx]);
                } else {
                  return null;
                }
            }
            if (s1AsChrArr[s2ChrIdx] != s2AsChrArr[s2ChrIdx]) {
                final String s1WthChrInsert = 
                    s1.substring(0, s2ChrIdx) + s2AsChrArr[s2ChrIdx] + s1.substring(s2ChrIdx, s1AsChrArr.length);
                if (s1WthChrInsert.equals(s2)) {
                  return String.valueOf(s2AsChrArr[s2ChrIdx]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }
        return null;
    }
    
    public static String checkDeleteCondition(final String s1, final String s2) {
        
        if (s1.length() - 1 != s2.length()) {
            return null;
        }
        final char[] s1AsChrArr = s1.toCharArray();
        final char[] s2AsChrArr = s2.toCharArray();
        for (int s1ChrIdx = 0; s1ChrIdx < s1AsChrArr.length; s1ChrIdx++) {
            if (s1ChrIdx == s1AsChrArr.length - 1) { //deal with corner case, at last char in s1
                final String s1WthChrDeleted = s1.substring(0, s1AsChrArr.length - 1);
                if (s1WthChrDeleted.equals(s2)) {
                  return String.valueOf(s1AsChrArr[s1ChrIdx]);
                } else {
                  return null;
                }
            }
            if (s1AsChrArr[s1ChrIdx] != s2AsChrArr[s1ChrIdx]) {
                final String s1WthChrDeleted = 
                    s1.substring(0, s1ChrIdx) + s1.substring(s1ChrIdx+1, s1AsChrArr.length);
                if (s1WthChrDeleted.equals(s2)) {
                  return String.valueOf(s1AsChrArr[s1ChrIdx]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }
        return null;
    }
    
    public static String checkSwapCondition(final String s1, final String s2) {
		
		if (s1.length() != s2.length()) {
			return null;
		}
		final char[] s1AsChrArr = s1.toCharArray();
		for (int s1ChrIdx = 0; s1ChrIdx < s1AsChrArr.length - 1; s1ChrIdx++) {
			swapArrElements(s1AsChrArr, s1ChrIdx, s1ChrIdx + 1);
			if (s2.equals(new String(s1AsChrArr))) {
				return s1AsChrArr[s1ChrIdx + 1] + " " + s1AsChrArr[s1ChrIdx];
			}
			swapArrElements(s1AsChrArr, s1ChrIdx, s1ChrIdx + 1); // reverse back to normal
		}
		return null;
	}

	public static void swapArrElements(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
}
