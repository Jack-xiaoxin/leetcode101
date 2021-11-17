package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

public class NumSquare {

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

    //试试用DFS
    public int numSquare(int n) {
        List<Integer> list = new ArrayList<>();
        for(int j = 1; j * j <= n; j++) {
            DFS(n-j*j, list, 1);
        }
        int min = Integer.MAX_VALUE;
        for(int count : list) {
            if(min > count) min = count;
        }
        return min;
    }

    public void DFS(int n, List<Integer> list, int count) {
        if(n == 0) {
            list.add(count);
            return ;
        }
        for(int j = 1; j * j <= n; j++) {
            DFS(n-j*j, list, count+1);
        }
    }
}
