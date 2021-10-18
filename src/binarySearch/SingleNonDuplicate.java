package binarySearch;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(mid-1 >= 0 && nums[mid-1] == nums[mid]) {
                if((right - mid) % 2 == 0) right = mid - 2;
                else left = mid + 1;
            } else if(mid + 1 <= nums.length-1 && nums[mid+1] == nums[mid]) {
                if((right - mid - 1) % 2 == 0) right = mid - 1;
                else left = mid + 2;
            } else return nums[mid];
        }
        return -1;
    }
}
