package dynamicProgramming;

import java.util.Arrays;

public class longestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < dp.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                if(max < dp[i]) max = dp[i];
            }
        }
        return max;
    }
}
