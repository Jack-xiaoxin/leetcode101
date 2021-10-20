package sortAlgorithm;

public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{2, 1}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickKthSort(nums, 0, nums.length-1, k);
    }

    public int quickKthSort(int[] nums, int left, int right, int k) {
        int first = left, last = right, key = nums[left];
        while(first < last) {
            while(first < last && nums[last] >= key) last--;
            nums[first] = nums[last];
            while(first < last && nums[first] <= key) first++;
            nums[last] = nums[first];
        }
        nums[first] = key;
        if(nums.length - last == k) return key;
        else if(nums.length - last > k && first < right) return quickKthSort(nums, first+1, right, k);
        else if(nums.length - last < k && left < first) return quickKthSort(nums, left, first-1, k);
        return -1;
    }
}
