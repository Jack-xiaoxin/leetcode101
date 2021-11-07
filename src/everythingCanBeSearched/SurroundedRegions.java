package everythingCanBeSearched;

public class SurroundedRegions {

    public void solve(char[][] board) {
        //在4个边界找O，并标记在数组visited中
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') DFS(i, 0, board, visited);
            if(board[i][board[i].length] == 'O') DFS(i, board[i].length, board, visited);
        }
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') DFS(0, i, board, visited);
            if(board[board.length][i] == 'O') DFS(board.length, i, board, visited);
        }
        for(int i = 1; i < board.length-1; i++) {
            for(int j = 1; j < board[i].length-1; j++) {
                if(board[i][j] == 'O' && visited[i][j] == 0) board[i][j] = 'X';
            }
        }
    }

    public void DFS(int i, int j, char[][] board, int[][] visited) {
        visited[i][j] = 1;
        int[] X = new int[]{1, -1, 0, 0}, Y = new int[]{0, 0, 1, -1};
        for(int k = 0; k < X.length; k++) {
            int newX = i + X[k], newY = j + Y[k];
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[newX].length &&
            board[newX][newY] == 'O' && visited[newX][newY] == 0)
                DFS(newX, newY, board, visited);
        }
    }
}
