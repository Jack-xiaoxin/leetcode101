package twoPointers;

public class SquareNumbers {

    public static void main(String[] args) {
        System.out.println(new SquareNumbers().judgeSquareSum1(1361));
    }

    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (int)Math.sqrt(c);
        while(left <= right) {
            //平方之和有可能超过整数范围，所以用long比较好
            long squareSum = left * left + right * right;
            if(squareSum > c) right--;
            else if(squareSum < c) left++;
            else return true;
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        long left = 0;
        long right = (int)Math.sqrt(c);
        while(left <= right) {
            //平方之和有可能超过整数范围，所以用long比较好
            long squareSum = left * left + right * right;
            if(squareSum > c) right = (int)Math.sqrt(c - left * left);
            else if(squareSum < c) {
                left = (int)Math.sqrt(c - right * right);
                if(left * left + right * right != c) left++;
            }
            else return true;
        }
        return false;
    }
}
