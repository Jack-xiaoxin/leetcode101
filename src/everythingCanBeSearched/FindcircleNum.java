package everythingCanBeSearched;

public class FindcircleNum {

    public int findCircleNum(int[][] isConnected) {
        int[][] visited = new int[isConnected.length][isConnected[0].length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    DFS(isConnected, visited, i, j);
                }
            }
        }
        return count;
    }

    public void DFS(int[][] isConnected, int[][] visited, int i, int j) {
        if(i >=0 && i < isConnected.length && j >= 0 && j < isConnected[i].length && visited[i][j] == 0 && isConnected[i][j] == 1) {
            visited[i][j] = 1;
            for(int index = 0; index < isConnected.length; index++) {
                DFS(isConnected, visited, j, index);
            }
        }
    }
}
