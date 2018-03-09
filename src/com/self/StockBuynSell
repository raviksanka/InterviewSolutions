package com.self;

public class StockBuynSell {
	
	public static void main(String[] args) {
	    int A[] = {5,14,4,1,9,12};

	    int min = A[0]; // Lets assume first element is minimum
	    int maxProfit = 0; // 0 profit, if we buy & sell on same day.
	    int profit = 0;
	    int minIndex = 0; // Index of buy date
	    int maxIndex = 0; // Index of sell date
	    //Run the loop from next element
	    for (int i = 1; i < A.length; i++) {
	        //Keep track of minimum buy price & index
	        if (A[i] < min) {
	            min = A[i];
	            minIndex = i;
	        }
	        profit = A[i] - min;
	        //If new profit is more than previous profit, keep it and update the max index
	        if (profit > maxProfit) {
	            maxProfit = profit;
	            maxIndex = i;
	        }
	    }
	    System.out.println("maxProfit is "+maxProfit);
	    System.out.println("minIndex is "+minIndex);
	    System.out.println("maxIndex is "+maxIndex);     
	}
}
