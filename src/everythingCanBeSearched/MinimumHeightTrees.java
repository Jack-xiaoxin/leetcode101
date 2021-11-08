package everythingCanBeSearched;

import java.util.*;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        int n = 4;
        new MinimumHeightTrees().findMinHeightTrees(4, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i = 0; i < n; i++) edgeList.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++) {
            int index1 = edges[i][0];
            int index2 = edges[i][1];
            edgeList.get(index1).add(index2);
            edgeList.get(index2).add(index1);
        }
        int[] visited = new int[n];
        List<Integer> result = new ArrayList<>();
        int minHeight = n;
        for(int i = 0; i < n; i++) {
            if(edgeList.get(i).size() > 0) {
                Arrays.fill(visited, 0);
                int len = BFS(i, edgeList, visited);
                if(len == minHeight) result.add(i);
                else if(len < minHeight) {
                    minHeight = len;
                    result.clear();
                    result.add(i);
                }
            }
        }
        if(minHeight == n) {
            for(int i = 0; i < n; i++)
                result.add(i);
        }
        return result;
    }

    public int BFS(int i, List<List<Integer>> edgeList, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int len = 0;
        visited[i] = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                for(int k : edgeList.get(cur)) {
                    if(visited[k] == 0) {
                        queue.offer(k);
                        visited[k] = 1;
                    }
                }
            }
            len++;
        }
        return len;
    }
}
