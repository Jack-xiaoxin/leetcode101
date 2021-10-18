package binarySearch;

public class SearchRotateArray {

    public boolean search(int[] nums, int target) {
        //先将排序数组还原
        int i = 1;
        while(i < nums.length) {
            if(nums[i] < nums[i-1]) break;
        }
        rotate(nums, 0, i-1);
        rotate(nums, i, nums.length-1);
        rotate(nums, 0, nums.length-1);
        int left = 0, right = nums.length-1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else return true;
        }
        return false;
    }

    public void rotate(int[] nums, int left, int right) {
        int temp;
        while(left < right) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}
