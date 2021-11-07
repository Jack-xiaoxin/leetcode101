package everythingCanBeSearched;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        new CombinationSum2().combinationSum2(candidates, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : candidates) {
            if(!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num)+1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        for(int i = 0; i < keyList.size(); i++) {
            DFS(i, keyList, 0, target, map, temp, result);
        }
        return result;
    }

    public void DFS(int keyIndex, List<Integer> keyList, int sum, int target, HashMap<Integer, Integer> map, List<Integer> temp, List<List<Integer>> result) {
        int key = keyList.get(keyIndex);
        temp.add(key);
        map.put(key, map.get(key)-1);
        sum += key;
        if(sum == target) result.add(new ArrayList<>(temp));
        else {
            for(int i = keyIndex; i < keyList.size(); i++) {
                int otherKey = keyList.get(i);
                if(map.get(otherKey) > 0 && sum + otherKey <= target)
                    DFS(i, keyList, sum, target, map, temp, result);
            }
        }
        temp.remove(temp.size()-1);
        map.put(key, map.get(key)+1);
    }
}
