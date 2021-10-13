package twoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        new ValidPalindrome().validPalindrome("abca");
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean flag = false;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i+1, j+1));
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}
