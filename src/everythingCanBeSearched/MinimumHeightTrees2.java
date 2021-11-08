package everythingCanBeSearched;

import java.util.*;

public class MinimumHeightTrees2 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degrees = new int[n];
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int index1 = edges[i][0];
            int index2 = edges[i][1];
            degrees[index1]++;
            degrees[index2]++;
            map.get(index1).add(index2);
            map.get(index2).add(index1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degrees[i] == 1) queue.add(i);
        }
        while(!queue.isEmpty()) {
            res.clear();
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                res.add(cur);
                for(int neighbor : map.get(cur)) {
                    degrees[neighbor]--;
                    if(degrees[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
