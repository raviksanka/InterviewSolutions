package com.self;

// Check if a value is present in N*N matrix which is sorted row wise and column wise
public class chkValueinNnNMatrix {

    public static void main(String[] args) {
        int[][] matrix = {  {10, 20, 30, 40},
                            {15, 25, 35, 45},
                            {27, 29, 37, 48},
                            {32, 33, 39, 50}};
        int numToFind = 36;
        checkInMatrix(matrix, numToFind);
    }
    static void checkInMatrix(int[][] mat, int numToFind)
    {
        if(mat.length == 0 || mat[0].length == 0) {
            System.out.println("Invalid Input");
            return;
        }
        int size = mat.length;
        if(numToFind < mat[0][0] || numToFind > mat[size-1][size-1]) {
            System.out.println("Number out of range of matrix - not found");
            return;
        }
        int rowToCheck = -1, columnToCheck = -1;
        for(int i = 0; i< size; i++) {
            if(numToFind > mat[i][0]) {
                rowToCheck++;
            }
            if(numToFind > mat[0][i]) {
                columnToCheck++;
            }
        }
        for(int i = 0; i < size; i++) {
            if(numToFind == mat[rowToCheck][i]) {
                System.out.println("Found at row "+ (rowToCheck+1) +" and column "+ (i+1));
                return;
            }
            if(numToFind == mat[i][columnToCheck]) {
                System.out.println("Found at row "+ (i+1) +" and column "+ (columnToCheck+1));
                return;
            }
        }
        System.out.println("Not able to find the number "+ numToFind + " in the matrix provided");
    }
}
