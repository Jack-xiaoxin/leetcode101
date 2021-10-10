package greedy;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility1(new int[]{3, 4, 2, 3}));
    }

    public boolean checkPossibility(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= nums[i-1]) list.add(nums[i]);
            else {
                List<Integer> temp = new ArrayList<>(list);
                lists.add(temp);
                list.clear();
                list.add(nums[i]);
            }
        }
        lists.add(list);
        if(lists.size() > 2) return false;
        else if(lists.size() == 1) return true;
        else {
            List<Integer> list1 = lists.get(0);
            List<Integer> list2 = lists.get(1);
            if(list1.size() == 1 || list2.size() == 1) return true;
            else if(list1.get(list1.size()-1) > list2.get(0) && list1.get(list1.size()-2) > list2.get(0) && list1.get(list1.size()-1) > list2.get(1)) return false;
            else return true;
        }
    }

    public boolean checkPossibility1(int[] nums) {
        int flag = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                if(flag == 0) {
                    if(i == 1 || nums[i] >= nums[i-2]) nums[i-1] = nums[i];
                    else nums[i] = nums[i-1];
                    flag = 1;
                } else return false;
            }
        }
        return true;
    }
}
