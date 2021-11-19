package dynamicProgramming;

public class DecodeWays {

    public static void main(String[] args) {
       int result = new DecodeWays().numDecodings("1123");
        System.out.println(result);
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);
            if(cur == '0') {
                if(pre == '0' || pre > '2') return 0;
                dp[i] = (i > 2 ? dp[i-2] : 1);
            } else if(pre == '0' || Integer.parseInt(""+pre+cur) > 26) dp[i] = dp[i-1];
            else dp[i] = dp[i-1] + (i > 2 ? dp[i-2] : 1);
        }
        return dp[dp.length-1];
    }
}
