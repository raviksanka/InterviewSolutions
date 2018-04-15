package com.self;

import java.util.*;

public class TransformingWords {

    public static void main(String args[] ) {

        String firstWord = null;
        String lastWord = null;
        int length;
        HashSet<String> dictionary = new HashSet<>();
        try {
            Scanner s = new Scanner(System.in);
            firstWord = s.nextLine();
            lastWord = s.nextLine();
            String dicLength = s.nextLine();
            length = Integer.valueOf(dicLength);
            for(int i = 1; i <=length; i++) {
                dictionary.add(s.nextLine());
            }
        } catch (Exception ex) {
            System.out.println(0);
        }
        TransformingWords test = new TransformingWords();
        System.out.println(test.findTransformationLength(firstWord, lastWord, dictionary));
    }

    private int findTransformationLength(String start, String end, HashSet<String> dict) {

        List<List<String>> result = new ArrayList<>();
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1, null));
        dict.add(end);
        int minStep = 0;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(dict);
        int preNumSteps = 0;
        while(!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;
            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }
                if(top.numSteps == minStep && minStep !=0){
                    ArrayList<String> t = new ArrayList<>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }
            preNumSteps = currNumSteps;
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        visited.add(newWord);
                    }
                    arr[i]=temp;
                }
            }
        }
        int length = dict.size();
        for(List<String> ab : result) {
            if(length > ab.size())
                length = ab.size();
        }
        return length;
    }

    class WordNode {
        String word;
        int numSteps;
        WordNode pre;

        WordNode(String word, int numSteps, WordNode pre) {
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }
    }

}