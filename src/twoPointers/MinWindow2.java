package twoPointers;

public class MinWindow2 {

    public static void main(String[] args) {
        System.out.println(new MinWindow2().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        boolean[] flags = new boolean[128];

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            flags[ch] = true;
            chars[ch]++;
        }

        int l = 0, minL = 0, cnt = 0, minSize = s.length() + 1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(flags[ch] && --chars[ch] >= 0) {
                cnt++;
            }
            while(cnt == t.length()) {
                if(i-l+1 < minSize) {
                    minSize = i-l+1;
                    minL = l;
                }
                char leftCh = s.charAt(l);
                if(flags[leftCh] && ++chars[leftCh] > 0) {
                    cnt--;
                }
                l++;
            }
        }
        return minSize > s.length() ? "" : s.substring(minL, minL+minSize);
    }
}
