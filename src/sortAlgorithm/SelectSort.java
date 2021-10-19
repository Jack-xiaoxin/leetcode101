package sortAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]) minIndex = j;
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
