package com.self;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String firstStr = in.nextLine();
        String secondStr = in.nextLine();
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = firstStr.indexOf(secondStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += secondStr.length();
            }
        }
        System.out.print(count);
        // From Apache Commons Lang // System.out.println(StringUtils.countMatches(firstStr, secondStr));
    }
}
