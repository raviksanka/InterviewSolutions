package com.self;

import java.util.*;

// Ascending Binary Sorting
public class AscendingBinarySorting {

    private static int[] rearrange(int[] elements) {
        //First line records the number and the second line records the amount of ones in binary representation of the number
        int[][] vectorNumberWithAmountOfOnes = new int[2][elements.length];
        /* For loop that is going through all elements of the elements array and will record the amount of this
                    binary representation in the second line of the array */
        int position = 0;
        for(int decimalNumber: elements) {
            /* Binary string representation of the decimal number*/
            String binaryRepresentationOfTheNumber = Integer.toBinaryString(decimalNumber);
            /* Counter that is going to keep the number of one in each representation of the decimal number*/
            int counter = 0;
            for(int j = 0; j <binaryRepresentationOfTheNumber.length(); j++) {
                if(binaryRepresentationOfTheNumber.charAt(j) == '1')
                    counter++;
            }
            vectorNumberWithAmountOfOnes[0][position] = decimalNumber;
            vectorNumberWithAmountOfOnes[1][position++] = counter;
        }
        /* Sort the vector comparing the amount of 1 in its binary representation if the amount of 1
                in its representation is equal, sort according the decimal weight */
        int n = elements.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (vectorNumberWithAmountOfOnes[1][i] > vectorNumberWithAmountOfOnes[1][k]) {
                    int t1 = vectorNumberWithAmountOfOnes[0][i];
                    int t2 = vectorNumberWithAmountOfOnes[1][i];
                    vectorNumberWithAmountOfOnes[0][i] = vectorNumberWithAmountOfOnes[0][k];
                    vectorNumberWithAmountOfOnes[1][i] = vectorNumberWithAmountOfOnes[1][k];
                    vectorNumberWithAmountOfOnes[0][k] = t1;
                    vectorNumberWithAmountOfOnes[1][k] = t2;
                } else if (vectorNumberWithAmountOfOnes[1][i] == vectorNumberWithAmountOfOnes[1][k]) {
                    if(vectorNumberWithAmountOfOnes[0][i] > vectorNumberWithAmountOfOnes[0][k]) {
                        int t1 = vectorNumberWithAmountOfOnes[0][i];
                        int t2 = vectorNumberWithAmountOfOnes[1][i];
                        vectorNumberWithAmountOfOnes[0][i] = vectorNumberWithAmountOfOnes[0][k];
                        vectorNumberWithAmountOfOnes[1][i] = vectorNumberWithAmountOfOnes[1][k];
                        vectorNumberWithAmountOfOnes[0][k] = t1;
                        vectorNumberWithAmountOfOnes[1][k] = t2;
                    }
                }
            }
        }
        for(int i = 0; i < elements.length; i ++) {
            elements[i] = vectorNumberWithAmountOfOnes[0][i];
        }
        return elements;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());
        int[] elements = new int[n];
        int element;
        for (int i = 0; i < n; i++) {
            element = Integer.parseInt(in.nextLine().trim());
            elements[i] = element;
        }
        // call rearrange function
        int[] results = rearrange(elements);
        for (int i : results) System.out.println(String.valueOf(i));
    }

}