package EverythingCanBeSearched;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3 });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for(int x : nums) numList.add(x);
        for(int i = 0; i < nums.length; i++) {
            DFS(i, numList, temp, result);
        }
        return result;
    }

    public void DFS(int i, List<Integer> numList, List<Integer> temp, List<List<Integer>> result) {
        temp.add(numList.get(i));
        int x = numList.remove(i);
        if(numList.size() == 0) result.add(new ArrayList<>(temp));
        else {
            for(int j = 0; j < numList.size(); j++) {
                DFS(j, numList, temp, result);
            }
        }
        temp.remove(temp.size()-1);
        numList.add(i, x);
    }
}
