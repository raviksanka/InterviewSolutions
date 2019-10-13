package com;

/*
    Level Order/Spiral Tree Traversal using O(n) time complexity and O(n) extra space.
        if no need of spiral, just remove usage of boolean ltr
*/

import java.util.ArrayDeque;
import java.util.Deque;

/* A binary tree node has data, pointer to left and right child */
class Node {
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

public class TreeTraveONWthDeQ {

    // Function to print Spiral order traversal of given binary tree
    public static void spiralOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        // create an empty double ended queue and enqueue root node or use deque
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);
        // flag used to print spiral traversal
        boolean ltr = false;
        // run till deque is not empty
        while (!deque.isEmpty()) {
            // calculate number of nodes in current level
            int nodeCount = deque.size();
            // print left to right
            if (ltr) {
                // process each node of current level and enqueue their non-empty left and right child to deque
                while (nodeCount > 0) {
                    // pop from front if flag is true
                    Node curr = deque.pollFirst();
                    System.out.print(curr.key + " ");
                    // push left child to end followed by right child if flag is true
                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }
                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }
                    nodeCount--;
                }
            }
            // print right to left
            else {
                // process each node of current level and enqueue their non-empty right and left child to queue
                while (nodeCount > 0) {
                    // Important - pop from back if flag is false
                    Node curr = deque.pollLast();
                    System.out.print(curr.key + " ");   // print front node
                    // Important - push right child to front followed by left child if flag is false
                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }
                    nodeCount--;
                }
            }
            // flip the flag for next level
            ltr = !ltr;
            System.out.println();
        }
    }

    // main function
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        spiralOrderTraversal(root);
    }
    
}
