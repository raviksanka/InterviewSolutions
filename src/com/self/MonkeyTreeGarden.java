package com.self;

import java.util.Scanner;

/** 
  In a garden, trees are arranged in a circular fashion with an equal distance between two adjacent trees. The height of trees may vary. 
  Two monkeys live in that garden and they were very close to each other. One day they quarreled due to some misunderstanding. 
  None of them were ready to leave the garden. But each one of them wants that if the other wants to meet him,
          it should take maximum possible time to reach him, given that they both live in the same garden.
  The conditions are that a monkey cannot directly jump from one tree to another. There are 30 trees in the garden. 
      If the height of a tree is H, a monkey can live at any height from 0 to H. 
      Lets say he lives at the height of K then it would take him K unit of time to climb down to the ground level.
      Similarly, if a monkey wants to climb up to K height it would again take K unit of time.
      The time to travel between two adjacent trees is 1 unit. A monkey can only travel in a circular fashion in the garden
                 because there is a pond at the center of the garden.
   So the question is where should two monkeys live such that the traveling time between them is maximum while
      choosing the shortest path between them in any direction clockwise or anti-clockwise. You have to answer only the maximum traveling time.

  Input Format
  The first line consists of total number of trees (N)
  Each of the following N lines contains the height of trees in a clockwise fashion.

  Constraints
  1 <= Total Trees <= 30
  1 <= Height Of Trees(H) <= 10000

  Output Format
  You must print an integer which will be the maximum possible travel time.
**/

public class MonkeyTreeGarden {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int noOfTrees = in.nextInt();
        int[] heightOfTrees = new int[noOfTrees];
        for(int i=0; i<noOfTrees; i++) {
            heightOfTrees[i] = in.nextInt();
        }
        System.out.print(max(0, heightOfTrees, heightOfTrees.length));
    }

    public static int max(int max, int[] listOfHeights, int orgArrayLength) {
        int length = listOfHeights.length;
        if (length == 1) {
            return Math.max(max, listOfHeights[0]);
        }
        int tempMax;
        int startIndex = 0;
        int[] tempArrayList =  new int[length-1];
        for(int index = 1; index < length; ++index) {
            tempMax = listOfHeights[startIndex] +
                    listOfHeights[index] + Math.min(index, orgArrayLength-index);
            max = Math.max(tempMax, max);
            tempArrayList[index-1] = listOfHeights[index];
        }
        return max(max, tempArrayList, orgArrayLength);
    }

}
