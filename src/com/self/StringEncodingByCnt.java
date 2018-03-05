package com.self;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StringEncodingByCnt {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        String res;
        String input;
        try {
            input = in.nextLine();
        } catch (Exception e) {
            input = null;
        }
        res = collapseString(input);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String collapseString(String input) {

        if(null == input || input.length() < 1)
            return input;
        StringBuilder result = new StringBuilder();
        char first = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch != first) {
                result.append(count).append(first);
                first = ch;
                count = 1;
            } else {
                count++;
            }
            first=ch;
        }
        result.append(count).append(first);
        return result.toString();
    }

}