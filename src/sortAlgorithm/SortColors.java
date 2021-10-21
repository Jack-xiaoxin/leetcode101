package sortAlgorithm;

public class SortColors {

    public void sortColors(int[] nums) {
        int countRed = 0, countWhite = 0, countBlue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) countRed++;
            else if(nums[i] == 1) countWhite++;
            else if(nums[i] == 2) countBlue++;
        }
        int index = 0;
        while(countRed-- > 0) nums[index++] = 0;
        while(countWhite-- > 0) nums[index++] = 1;
        while(countBlue-- > 0) nums[index++] = 2;
    }

    public void sortColors1(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else if(nums[i] == 2) {
                nums[num2++] = 2;
            }
        }
    }
}
