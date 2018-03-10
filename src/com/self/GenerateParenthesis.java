package com.self;

import java.util.ArrayList;

/*
 * This file is used to generate all possible combn of parenthesis.
 */
public class GenerateParenthesis {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static String generateParenthesis(int pair) {
		ArrayList<String> allPossCombn = new ArrayList<String>();
		paranCombn(allPossCombn, "", pair, pair);
		return allPossCombn.toString();
	}

	public static void paranCombn(ArrayList<String> allPossCombn, String s, int left, int right) {
		if (left > right)
			return;
		if (left == 0 && right == 0) {
			allPossCombn.add(s);
			return;
		}
		if (left > 0) {
			paranCombn(allPossCombn, s + "(", left - 1, right);
		}
		if (right > 0) {
			paranCombn(allPossCombn, s + ")", left, right - 1);
		}
	}
}
