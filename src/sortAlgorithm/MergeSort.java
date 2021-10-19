package sortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return ;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, mid+1, right);
    }

    public static void merge(int[] nums, int left1, int right1, int left2, int right2) {
        List<Integer> list = new ArrayList<>();
        int i = left1, j = left2;
        while(i <= right1 && j <= right2) {
            if(nums[i] < nums[j]) list.add(nums[i++]);
            else list.add(nums[j++]);
        }
        while(i <= right1) list.add(nums[i++]);
        while(j <= right2) list.add(nums[j++]);
        for(int k = left1; k <= right2; k++) {
            nums[k] = list.get(k-left1);
        }
    }
}
