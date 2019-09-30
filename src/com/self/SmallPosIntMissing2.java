import java.util.Arrays;

public class SmallPosIntMissing2 {

    /*
       We have created a list full of 0’s with size of the max() value of our given array.
          Now, whenever we encounter any +ve value in original array, we change the index value of our list to 1.
            So, after we are done, the first 0 we encounter in new list, its (index value + 1) should be our answer.
     */
    static int solution(int[] A) { // Our original array
        int m = Arrays.stream(A).max().getAsInt(); // Storing maximum value
        if (m < 1) {
            // In case all values in our array are negative
            return 1;
        }
        if (A.length == 1) {
            // If it contains only one element
            if (A[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        int i = 0;
        int[] l = new int[m];
        for (i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (l[A[i] - 1] != 1) {
                    // Changing the value status at the index of our list
                    l[A[i] - 1] = 1;
                }
            }
        }
        for (i = 0; i < l.length; i++) {
            // Encountering first 0, i.e, the element with least value
            if (l[i] == 0) {
                return i + 1;
            }
        }
        // In case all values are filled between 1 and m
        return i + 1;
    }

    public static void main(String[] args) {

        int A[] = {0, 10, 2, -10, -20};
        System.out.println(solution(A));
    }
    
}
