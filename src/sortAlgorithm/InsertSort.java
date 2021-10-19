package sortAlgorithm;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i-1;
            while(j >= 0 && temp < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }
}
