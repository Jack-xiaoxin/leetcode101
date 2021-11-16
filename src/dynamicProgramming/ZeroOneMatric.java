package dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatric {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
//        int[][] mat = new int[][]{{0}, {1}};
        int[][] result = new ZeroOneMatric().updateMatrix1(mat);
        for(int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for(int[] row : result) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int level = 1;
        int[] direction = new int[]{0, 1, 0, -1, 0};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] pos = queue.poll();
                for(int i  = 0; i < 4; i++) {
                    int newX = pos[0] + direction[i];
                    int newY = pos[1] + direction[i+1];
                    if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[newX].length && result[newX][newY] == -1) {
                        queue.offer(new int[]{newX, newY});
                        result[newX][newY] = level;
                    }
                }
            }
            level++;
        }
        return result;
    }

    public int[][] updateMatrix1(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE-10000);
        }
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) dp[i][j] = 0;
                else {
                    if(i > 0) dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j]);
                    if(j > 0) dp[i][j] = Math.min(dp[i][j-1]+1, dp[i][j]);
                }
            }
        }
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(i < mat.length-1) dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
                if(j < mat.length-1) dp[i][j] = Math.min(dp[i][j], dp[i][j+1]+1);
            }
        }
        return dp;
    }
}
