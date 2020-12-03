package com.self;

import java.util.Scanner;

// Add 2 matrix of varying size given input into 1 matrix
public class AddMatrixOfVarSize {
    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);
        String[] temp;
        temp = in.nextLine().split(" ");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        int first[][] = new int[m][n];
        for(int i =0;i<m;i++) {
            String[] curr = in.nextLine().split(" ");
            for (int j = 0; j < n; j++)
                first[i][j] = Integer.parseInt(curr[j]);
        }

        temp = in.nextLine().split(" ");
        int p = Integer.parseInt(temp[0]);
        int q = Integer.parseInt(temp[1]);
        int second[][] = new int[p][q];
        for(int i =0;i<p;i++) {
            String[] curr = in.nextLine().split(" ");
            for (int j = 0; j < q; j++)
                second[i][j] = Integer.parseInt(curr[j]);
        }
        int a = m > p ? m : p;
        int b = n > q ? n : q;
        int sum[][] = new int[a][b];
        int x,y;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                try {
                    x = first[i][j];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    x = 0;
                }
                try {
                    y = second[i][j];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    y = 0;
                }
                sum[i][j] = x + y;  //replace '+' with '-' to subtract matrices
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(sum[i][j]);
                if(j!=b-1)
                    System.out.print(" ");
            }
            if(i != a-1)
                System.out.println();
        }
    }
}
