package greedy;

import sun.jvm.hotspot.types.CIntegerType;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowShots {

    public static void main(String[] args) {
//        int result = new ArrowShots().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        int result = new ArrowShots().findMinArrowShots(new int[][]{{10, 16}, {2, 8}});
        System.out.println(result);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] interval = points[0];
        int shots = 1;
        for(int i = 1; i < points.length; i++) {
            //判断起始位置是不是超过重合区间的结束位置
            //如果是的话，说明要多开一枪，并重新更新重合区间
            //如果不是的话，更新重合区间
            if(points[i][0] > interval[1]) {
                shots++;
                interval = points[i];
            } else {
                interval[0] = points[i][0];
                interval[1] = Math.min(points[i][1], interval[1]);
            }
        }
        return shots;
    }
}
