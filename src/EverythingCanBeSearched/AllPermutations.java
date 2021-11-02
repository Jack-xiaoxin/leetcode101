package EverythingCanBeSearched;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {

    public static void main(String[] args) {
        List<List<Integer>> result = new AllPermutations().permuteUnique(new int[]{1, 1, 3});
        for(List<Integer> list : result) System.out.println(list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for(int num : nums) numList.add(num);
        for(int i = 0; i < numList.size(); i++) {
            int num = numList.remove(i);
            DFS(num, numList, temp, set);
            numList.add(i, num);
        }
        return new ArrayList<List<Integer>>(set);
    }

    public void DFS(int num, List<Integer> numList, List<Integer> temp, Set<List<Integer>> set) {
        temp.add(num);
        if(numList.size() == 0) set.add(new ArrayList<>(temp));
        else {
            for(int i = 0; i < numList.size(); i++) {
                int otherNum = numList.remove(i);
                DFS(otherNum, numList, temp, set);
                numList.add(i, otherNum);
            }
        }
        temp.remove(temp.size()-1);
    }


}
