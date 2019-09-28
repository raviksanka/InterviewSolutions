/*
    Given an array, print the Next Smaller Element (NSE) for every element.
        The Smaller smaller Element for an element x is the first smaller element on the right side of x in array.
            Elements for which no smaller element exist (on right side), consider next smaller element as -1.
 */

import java.util.HashMap;
import java.util.Stack;

public class NextSmallerNum {
    /*
    1) Push the first element to stack.
    2) Pick rest of the elements one by one and follow following steps in loop.
        ….a) Mark the current element as next.
        ….b) If stack is not empty, then pop an element from stack and compare it with next.
        ….c) If next is smaller than the popped element, then next is the next smaller element for the popped element.
        ….d) Keep popping from the stack while the popped element is greater than next.
                        next becomes the next smaller element for all such popped elements
    3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
     */

    public static void main (String[] args) {
        int arr[] = { 11, 13, 21, 3};
        int n = arr.length;
        printNSE(arr, n);
    }

    public static void printNSE(int arr[], int n) {

        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        /* push the first element to stack */
        s.push(arr[0]);
        // iterate for rest of the elements
        for (int i = 1; i < n; i++) {
            if (s.empty()) {
                s.push(arr[i]);
                continue;
            }
            /* if stack is not empty, then pop an element from stack.
                If the popped element is smaller than next, then
                    a) print the pair
                    b) keep popping while elements are smaller and stack is not empty
            */
            while (s.empty() == false && s.peek() > arr[i]) {
                mp.put(s.peek(), arr[i]);
                s.pop();
            }
            /* push next to stack so that we can find next smaller for it */
            s.push(arr[i]);
        }
        /* After iterating over the loop, the remaining elements in stack do not have the next smaller element,
                        so print -1 for them */
        while (s.empty() == false) {
            mp.put(s.peek(), -1);
            s.pop();
        }
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " ---> " + mp.get(arr[i]));
    }
}
