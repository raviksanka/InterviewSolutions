package com.self;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisMatcher {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String inputSentence = scan.nextLine();
        int openingBraceNum = Integer.parseInt(scan.nextLine().trim());
        int res = closingBracePosition(inputSentence, openingBraceNum);
        bw.write(String.valueOf(res));
        bw.newLine();
        bw.close();
    }

    static int closingBracePosition(String inputSentence, int openingBraceNum) {

        if(!checkForBalanced(inputSentence))
            return -1;
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < inputSentence.length(); i++) {
            char c = inputSentence.charAt(i);
            if (c == '(') {
                stk.push(i);
            } else if(c == ')') {
                try {
                    stk.pop();
                    if(stk.size() == openingBraceNum -1)
                        return i+1;
                } catch(Exception e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    static boolean checkForBalanced(String input) {

        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                if (counter == 0) {
                    return false;    // Close parenthesis appear without a corresponding open
                } else {
                    counter--;
                }
            }
        }
        return counter == 0;
    }

}