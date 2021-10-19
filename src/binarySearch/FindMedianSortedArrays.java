package binarySearch;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        int index1 = (m+n+1) / 2, index2 = (m+n+2) / 2;
        int count  = 0;
        int num1 = 0, num2 = 0;
        while(i < nums1.length && j < nums2.length && (count <= index1 || count <= index2)) {
            if(nums1[i] < nums2[j]) {
                count++;
                if(count == index1) num1 = nums1[i];
                if(count == index2) num2 = nums1[i];
                i++;
            }
            else {
                count++;
                if(count == index1) num1 = nums2[j];
                if(count == index2) num2 = nums2[j];
                j++;
            }
        }
        while(i < nums1.length && (count <= index1 || count <= index2)) {
            count++;
            if(count == index1) num1 = nums1[i];
            if(count == index2) num2 = nums1[i];
            i++;
        }
        while(j < nums2.length && (count <= index1 || count <= index2)) {
            count++;
            if(count == index1) num1 = nums2[j];
            if(count == index2) num2 = nums2[j];
            j++;
        }
        return (num1+num2) / 2.0;
    }
}
