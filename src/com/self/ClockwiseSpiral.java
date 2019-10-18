/*
   Given a Binary Tree. The task is to print the circular clockwise spiral order traversal of the given binary tree.
           Input :
                   20
                 /   \
                8     22
              /   \  /   \
             5     3 4    25
                  / \
                 10  14
        Output :20 14 10 8 22 25 4 3 5

        The idea is to use two variables i initialized to 1 and j initialized to the height of tree and
            run a while loop which wont break until i becomes greater than j.
        We will use another variable flag and initialize it to 0. Now in the while loop we will check a condition
            that if flag is equal to 0 we will traverse the tree from left to right and mark flag as 1
            so that next time we traverse the tree from right to left and then increment the value of i
            so that next time we visit the level just below the current level.
        Also when we will traverse the level from bottom we will mark flag as 0 so that
            next time we traverse the tree from right to left and then decrement the value of j so that
            next time we visit the level just above the current level.
        Repeat the whole process until the binary tree is completely traversed.
*/

public class ClockwiseSpiral {

    // Binary tree node  
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive Function to find height of binary tree  
    static int height(Node root) {
        
        // Base condition 
        if (root == null)
            return 0;
        // Compute the height of each subtree
        int lheight = height(root.left);
        int rheight = height(root.right);
        // Return the maximum of two  
        return Math.max(1 + lheight, 1 + rheight);
    }

    // Function to Print Nodes from left to right  
    static void leftToRight(Node root, int level) {
        
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            leftToRight(root.left, level - 1);
            leftToRight(root.right, level - 1);
        }
    }

    // Function to Print Nodes from right to left  
    static void rightToLeft(Node root, int level) {
        
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            rightToLeft(root.right, level - 1);
            rightToLeft(root.left, level - 1);
        }
    }

    // Function to print clockwise spiral traversal of a binary tree without using 2D array  
    static void ClockWiseSpiral(Node root) {
        
        int i = 1;
        int j = height(root);
        // Flag to mark a change in the direction of printing nodes
        int flag = 0;
        while (i <= j) {
            // If flag is zero print node from left to right  
            if (flag == 0) {
                leftToRight(root, i);
                // Set the value of flag as one so that nodes are next time printed from right to left
                flag = 1;
                // Increment i  
                i++;
            }
            // If flag is one print nodes from right to left  
            else {
                rightToLeft(root, j);
                // Set the value of flag as zero so that nodes are next time printed from left to right
                flag = 0;
                // Decrement j  
                j--;
            }
        }
    }

    // Driver code  
    public static void main(String[] args) {
        
        Node root = new Node(10);

        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        ClockWiseSpiral(root);
    }

}
