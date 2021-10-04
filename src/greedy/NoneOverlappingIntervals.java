package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间问题
 * 假设所有区间以【a,b】命名，则将所有区间按照b进行增序排序。
 * 第一个一定要选，然后后面每一次都放弃与前一个区间重合的区间
 */
public class NoneOverlappingIntervals {

    public static void main(String[] args) {
        int result = new NoneOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {1,3}, {2,4}});
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] pre = intervals[0];
        int eraseNum = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < pre[1]) eraseNum++;
            else pre = intervals[i];
        }
        return eraseNum;
    }
}
