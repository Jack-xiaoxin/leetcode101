package everythingCanBeSearched;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    max = Math.max(max, DFS(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    public int DFS(int[][] grid, int[][] visited, int i, int j) {
        if(i >=0 && i < grid.length && j >= 0 && j < grid[i].length && visited[i][j] == 0 && grid[i][j] == 1) {
            visited[i][j] = 1;
            int result = 1;
            int[] X = {-1, 1, 0, 0}, Y = {0, 0, 1, -1};
            for(int index = 0; index < X.length; index++) {
                result += DFS(grid, visited, i+X[index], j+Y[index]);
            }
            return result;
        } else return 0;
    }
}
