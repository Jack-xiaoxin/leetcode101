package greedy;

import java.util.*;

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] result = new ReconstructQueue().reconstructQueue1(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for(int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        //执行插入，将每个元素插入到刚好满足条件的位置
        List<int[]> list = new LinkedList<>();
        list.add(people[0]);
        for(int i = 1; i < people.length; i++) {
            int count = 0;
            for(int j = i-1; j >= 0; j--) {
                int[] temp = list.get(j);
                if(temp[0] >= people[i][0]) count++;
            }
            int gap = count - people[i][1];
            int j = i-1;
            for(; j >= 0 && gap > 0; j--) {
                int[] temp = list.get(j);
                if(temp[0] >= people[i][0]) gap--;
            }
            list.add(j+1, people[i]);
        }
        return list.toArray(people);
    }

    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] peo : people) {
            list.add(peo[1], peo);
        }
        return list.toArray(people);
    }
}
