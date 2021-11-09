package everythingCanBeSearched;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i-2 < 0) dp[i] = Math.max(dp[i-1], nums[i]);
            else dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[dp.length-1];
    }
}
