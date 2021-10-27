package EverythingCanBeSearched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    public static void main(String[] args) {
        new PacificAtlantic().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        int[][] visited = new int[heights.length][heights[0].length];
        //对4条边上的节点进行搜索
        for(int i = 0; i < heights[0].length; i++) DFS(heights, visited, pacific, 0, i);
        for(int i = 0; i < heights.length; i++) DFS(heights, visited, atlantic, i, 0);
        for(int[] row : visited) {
            Arrays.fill(row, 0);
        }
        for(int i = 0; i < heights[0].length; i++) DFS(heights, visited, pacific, heights.length-1, i);
        for(int i = 0; i < heights.length; i++) DFS(heights, visited, atlantic, i, heights[i].length-1);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[i].length; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public void DFS(int[][] heights, int[][] visited, int[][] ocean, int i, int j) {
        visited[i][j] = 1;
        ocean[i][j] = 1;
        int[] X = {1, -1, 0, 0}, Y = {0, 0, 1, -1};
        for(int k = 0; k < X.length; k++) {
            int newX = i + X[k], newY = j + Y[k];
            if(newX >= 0 && newX < heights.length
                    && newY >= 0 && newY < heights[i].length
                    && visited[newX][newY] == 0 && heights[i][j] <= heights[newX][newY]) {
                DFS(heights, visited, ocean, newX, newY);
            }
        }
    }
}
