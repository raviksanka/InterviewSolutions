import java.util.*;

/*
    Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
     Find all possible words that can be formed by a sequence of adjacent characters. We can move to any of 8 chars,
       but a word should not have multiple instances of same cell.
 */
public class FindWordsInDic {

    /*
       The idea is to consider every character as a starting character and find all words starting with it.
        All words starting from a char can be found using Depth First Traversal. We do DFT starting from every cell.
         We keep track of visited cells to make sure that a cell is considered only once in a word.
     */
    // Let the given dictionary be following
    static final List<String> dictionary = new ArrayList<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GUQ", "EE"));
    static final int n = dictionary.size();
    static final int M = 3, N = 3;

    // A recursive function to print all words present on boggle
    static void findWordsUtil(char boggle[][], boolean visited[][], int i, int j, String str, Set<String> wordsInDic) {
        // Mark current cell as visited and append current character to str
        visited[i][j] = true;
        str = str + boggle[i][j];

        // If str is present in dictionary, then print it
        if (dictionary.contains(str))
            wordsInDic.add(str);

        // Traverse 8 adjacent cells of boggle[i][j]
        for (int row = i - 1; row <= i + 1 && row < M; row++)
            for (int col = j - 1; col <= j + 1 && col < N; col++)
                if (row >= 0 && col >= 0 && !visited[row][col])
                    findWordsUtil(boggle, visited, row, col, str, wordsInDic);

        // Erase current character from string and mark visited of current cell as false
        str = "" + str.charAt(str.length() - 1);
        visited[i][j] = false;
    }

    // Prints all words present in dictionary.
    static void findWords(char boggle[][]) {

        // Mark all characters as not visited
        boolean visited[][] = new boolean[M][N];
        String str = "";
        Set<String> wordsInDic = new HashSet<>();
        // Consider every character and look for all words starting with this character
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(boggle, visited, i, j, str, wordsInDic);
        System.out.println(wordsInDic);
    }

    // Driver program to test above function
    public static void main(String args[]) {
        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        System.out.println("Following words of dictionary are present");
        findWords(boggle);
    }

}
