/*
    Given a 2D board and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cell.
               where "adjacent" cells are those horizontally or vertically neighboring (only 4-directional).
 */
public class FindWordsInDic4D {

    /*
       This problem can be solve by using a typical DFS algorithm.
     */
    public static void main(String args[]) {

        char boggle[][] = { {'A', 'B', 'C','E'},
                            {'S', 'F', 'C','S'},
                            {'A', 'D', 'E','E'} };
        System.out.println(exist(boggle, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int k) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }

}
