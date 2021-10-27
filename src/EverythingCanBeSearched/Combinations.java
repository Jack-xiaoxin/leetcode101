package EverythingCanBeSearched;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) numList.add(i);
        for(int i = 0; i < numList.size(); i++) {
            DFS(i, numList, temp, result, k);
        }
        return result;
    }

    public void DFS(int i, List<Integer> numList, List<Integer> temp, List<List<Integer>> result, int k) {
        temp.add(numList.get(i));
        if(temp.size() == k) result.add(new ArrayList<>(temp));
        else {
            for(int j = i+1; j < numList.size(); j++) {
                DFS(j, numList, temp, result, k);
            }
        }
        temp.remove(temp.size()-1);
    }
}
