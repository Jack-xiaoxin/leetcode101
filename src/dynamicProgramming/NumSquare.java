package dynamicProgramming;

import java.util.Arrays;

public class NumSquare {

    int result = 0;

    //dp[i]不由临近的元素确定，而是min(dp[i-1], dp[i-4], dp[i-9]...)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
