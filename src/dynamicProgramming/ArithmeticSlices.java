package dynamicProgramming;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <= 2 ) return 0;
        int[] dp = new int[nums.length];
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                dp[i] = dp[i-1] + 1;
        }
        int result = 0;
        for(int i = 0; i < dp.length; i++)
            result += dp[i];
        return result;
    }
}
