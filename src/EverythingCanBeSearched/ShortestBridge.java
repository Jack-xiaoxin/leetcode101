package EverythingCanBeSearched;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }

    public int shortestBridge(int[][] grid) {
        //先DFS找到其中一个岛屿，并全部标记为2
        boolean flag = false;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(flag) break;
                if(grid[i][j] == 1) {
                    flag = true;
                    DFS(i, j, grid, queue);
                    break;
                }
            }
        }
        int level = 0;
        int[] directions = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] temp = queue.poll();
                for(int k = 0; k < directions.length-1; k++) {
                    int newX = temp[0] + directions[k], newY = temp[1] + directions[k+1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length &&
                            grid[newX][newY] != 2) {
                        if(grid[newX][newY] == 1) return level;
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public void DFS(int i, int j, int[][] grid, Queue<int[]> queue) {
        queue.offer(new int[]{i, j});
        grid[i][j] = 2;
        int[] X = {1, -1, 0, 0}, Y = {0, 0, 1, -1};
        for(int k = 0; k < X.length; k++) {
            int newX = i + X[k], newY = j + Y[k];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length &&
                    grid[newX][newY] == 1) DFS(newX, newY, grid, queue);
        }
    }
}
