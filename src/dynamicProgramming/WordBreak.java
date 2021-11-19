package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "dogs";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("dog");
        wordDict.add("s");
        wordDict.add("gs");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(String word : wordDict) {
                int len = word.length();
                if(i == len-1 && s.substring(0, i+1).equals(word)) dp[i] = true;
                else if(i > len-1 && s.substring(i-len+1, i+1).equals(word) && !dp[i]) dp[i] = dp[i-len];
            }
        }
        return dp[dp.length-1];
    }
}
