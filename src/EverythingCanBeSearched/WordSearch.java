package EverythingCanBeSearched;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        new WordSearch().exist(board, "ABCESEEEFS");
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char beginChar = word.charAt(0);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == beginChar) {
                    if(DFS(i, j, 0, board, word, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(int i, int j, int index, char[][] board, String word, boolean[][] visited) {
        visited[i][j] = true;
        index++;
        if(index == word.length()) return true;
        int[] X = new int[]{1, -1, 0, 0}, Y = new int[]{0, 0, 1, -1};
        for(int k = 0; k < X.length; k++) {
            int newx = i + X[k], newy = j + Y[k];
            if(newx >= 0 && newx < board.length && newy >= 0 && newy < board[i].length
                    && !visited[newx][newy] && board[newx][newy] == word.charAt(index)) {
                if(DFS(newx, newy, index, board, word, visited)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
