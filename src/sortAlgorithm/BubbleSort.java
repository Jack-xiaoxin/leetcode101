package sortAlgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j+1] < nums[j]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
