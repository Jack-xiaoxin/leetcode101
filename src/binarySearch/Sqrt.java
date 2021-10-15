package binarySearch;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long temp = (long)mid * mid;
            if(temp > x) right = mid - 1;
            else if(temp < x) left = mid + 1;
            else return mid;
        }
        return right;
    }
}
