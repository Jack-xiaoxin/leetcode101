package sortAlgorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int l, int r) {
        int key = nums[l], i = l, j = r;
        while(i < j) {
            while(i < j && nums[j] >= key) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= key) i++;
            nums[j] = nums[i];
        }
        nums[i] = key;
        if(l < i-1) quickSort(nums, l, i-1);
        if(i+1 < r) quickSort(nums, i+1, r);
    }
}
