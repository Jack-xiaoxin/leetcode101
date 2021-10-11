package twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinWindow {

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        boolean[] flags = new boolean[128];
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            flags[ch] = true;
            chars[ch]++;
        }
        int l = 0, cnt = 0, minSize = s.length()+1;
        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if(flags[ch] && --chars[ch] >= 0) {
                cnt++;
            }
            while(cnt == t.length()) {
                if(r-l+1 < minSize) minSize = r-l+1;
                char leftCh = s.charAt(l);
                if(flags[leftCh] && ++chars[leftCh] > 0) cnt--;
                l++;
            }
        }
        return minSize > s.length() ? "" : s.substring(l, minSize-1+l);
    }
}
