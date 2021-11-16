package dynamicProgramming;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++){
                if(i-1 >= 0 && j-1 >= 0) dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                else if(i-1 >= 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else if(j-1 >= 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else dp[i][j] = grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int minPathSum2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(i-1 >= 0 && j-1 >= 0) dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                else if(i-1 >= 0) dp[j] = dp[j] + grid[i][j];
                else if(j-1 >= 0) dp[j] = dp[j-1] + grid[i][j];
                else dp[j] = grid[i][j];
            }
        }
        return dp[dp.length-1];
    }
}
