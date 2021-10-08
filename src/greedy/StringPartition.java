package greedy;

import java.util.*;

public class StringPartition {

    public static void main(String[] args) {
        System.out.println(new StringPartition().partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.get(ch)[1] = i;
            else {
                map.put(ch, new int[2]);
                map.get(ch)[0] = i;
                map.get(ch)[1] = i;
            }
        }
        List<int[]> intervals = new ArrayList<int[]>(map.values());
        intervals.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Integer> result = new ArrayList<>();
        int[] pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i)[0] > pre[1]) {
                result.add(pre[1]-pre[0]+1);
                pre = intervals.get(i);
            } else {
                pre[1] = Math.max(intervals.get(i)[1], pre[1]);
            }
        }
        result.add(pre[1]-pre[0]+1);
        return result;
    }
}
