package dynamicProgramming;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    if(i > 0 & j > 0) dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    else dp[i][j] = 1;
                }
                if(max < dp[i][j]) max = dp[i][j];
            }
        }
        return max * max;
    }
}
