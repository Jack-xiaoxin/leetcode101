package binarySearch;

import java.util.List;

import java.util.ArrayList;

public class SearchRange {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int resultL = -1, resultR = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else {
                resultL = mid;
                resultR = mid;
                while((resultL-1) >= 0 && nums[resultL-1] == target) resultL--;
                while((resultR+1) < nums.length && nums[resultR+1] == target) resultR++;
            }
        }
        return new int[]{resultL, resultR};
    }
}
