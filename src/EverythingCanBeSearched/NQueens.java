package EverythingCanBeSearched;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(4);
        for(List<String> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<Integer> temp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            DFS(i, n, temp, result);
        }
        return result;
    }

    public void DFS(int i, int n, List<Integer> temp, List<List<String>> result) {
        temp.add(i);
        if(temp.size() == n) {
            List<String> aAns = new ArrayList<>();
            for(int j = 0; j < temp.size(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                for(int k = 0; k < n; k++) {
                    if(k == temp.get(j)) stringBuilder.append('Q');
                    else stringBuilder.append('.');
                }
                aAns.add(stringBuilder.toString());
            }
            result.add(aAns);
        }
        else {
            for(int j = 0; j < n; j++) {
                boolean flag = false;
                for(int k = 0; k < temp.size(); k++) {
                    if(temp.get(k) == j || Math.abs(temp.size()-k) == Math.abs(j-temp.get(k))) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) DFS(j, n, temp, result);
            }
        }
        temp.remove(temp.size()-1);
    }
}
