package greedy;

import java.util.Arrays;

/**
 * 饥饿度最小的小孩最容易吃饱，所以先考虑饥饿度小一些的孩子。
 * 为了尽量使剩下的饼干可以满足饥饿度更大的孩子，应该把大于等于这个孩子饥饿度的，且大小最小的饼干给这个孩子
 * 直到没有满足条件的饼干存在
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int child = 0, cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(child < g.length && cookie < s.length) {
            if(g[child] <= s[cookie]) child++;
            cookie++;
        }
        return child;
    }
}
