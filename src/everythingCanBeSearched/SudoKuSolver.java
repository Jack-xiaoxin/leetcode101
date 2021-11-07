package everythingCanBeSearched;

import java.util.List;

import java.sql.Array;
import java.util.ArrayList;

public class SudoKuSolver {

    boolean isOver = false;

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new SudoKuSolver().solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        List<int[]> spaceList = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') spaceList.add(new int[]{i, j});
            }
        }
        DFS(0, spaceList, board);
    }

    public void DFS(int index, List<int[]> spaceList, char[][] board) {
        if(index >= spaceList.size()) isOver = true;
        if(isOver) return ;
        int[] pos = spaceList.get(index);
        for (char ch = '1'; ch <= '9'; ch++) {
            if(panduan(pos, ch, board)) {
                board[pos[0]][pos[1]] = ch;
                DFS(index+1, spaceList, board);
                //不写判断的话，回溯会把board数组恢复原样
                if(!isOver) board[pos[0]][pos[1]] = '.';
            }
        }
    }

    public boolean panduan(int[] pos, char ch,  char[][] board) {
        int i = pos[0], j = pos[1];
        //判断每一行
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == ch) return false;
        }
        //判断每一列
        for(int k = 0; k < board[i].length; k++) {
            if (board[i][k] == ch) return false;
        }
        //判断每一个方格
        for(int m = i/3*3; m < (i/3+1)*3; m++) {
            for (int n = j / 3 * 3; n < (j / 3 + 1) * 3; n++) {
                if (board[m][n] == ch) return false;
            }
        }
        return true;
    }


}