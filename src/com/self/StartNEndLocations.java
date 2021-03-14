package com.self;

/*
Packages are sent to our shipping center via a series of autonomous delivery carts,
  each of which moves packages on a one-way route. Using input that provides the (directed) steps that each cart takes as pairs,
    write a function that identifies all the start locations, and a list of possible ending locations for each start location.
The output keys and values should be printed in sorted order.
In this diagram, starting locations are at the top and destinations are at the bottom - i.e. the graph is directed exclusively downward.
   A         E      J
  / \       / \      \
 B   C     F   L      M
  \ /     /
   K     G
        / \
       H   I
Example input
  A B
  A C
  B K
  C K
  E L
  F G
  J M
  E F
  G H
  G I
Example output
  A: K
  E: H I L
  J: M
Clarifications: All paths will be valid, and each location will be identified by a unique string. There are no cycles in the input data.
*/

public class StartNEndLocations {
  
    static Map<String, List<String>> adj = new HashMap<>(); // adjacent list
    static Map<String, Set<String>> ans = new TreeMap<>();

    public static void main(String[] args) {
        findStartAndEndLocations(new String[][]{});
    }
  
    static void findStartAndEndLocations(String[][] pairs) {
        // keeps all strings that have at-least one parent
        Set<String> children = new HashSet<>();
        for (String[] pair : pairs) {
            if (!adj.containsKey(pair[0])) {
                // add key if not present
                adj.put(pair[0], new LinkedList<>());
            }
            // add to adjacent list
            adj.get(pair[0]).add(pair[1]);
            children.add(pair[1]);
        }
        for(String node: adj.keySet()) {
            // if node is not a child of any node
            // i.e it is a starting location
            Set<String> visited = new HashSet<>();
            if(!children.contains(node)) {
                // add all leaf nodes as destinations
                dfs(node, "", node, visited);
            }
        }
        for(String node: ans.keySet()) {
            System.out.print(node + ": ");
            for(String destination: ans.get(node)) {
                System.out.print(destination + " ");
            }
            System.out.println();
        }
    }
  
  static void dfs(String node, String parent, String start, Set<String> visited) {
        // mark node as visited
        visited.add(node);
        // if node has no child it is a leaf node
        if(!adj.containsKey(node)) {
            if (!ans.containsKey(start)) {
                // ensure ans has the start key
                ans.put(start, new TreeSet<>());
            }
            ans.get(start).add(node);
            return;
        }
        for(String child: adj.get(node)){
            if(!child.equals(parent) && !visited.contains(child)) {
                dfs(child, node, start, visited);
            }
        }
    }
}
