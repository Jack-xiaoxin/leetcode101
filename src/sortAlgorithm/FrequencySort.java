package sortAlgorithm;

import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        new FrequencySort().frequencySort("tree");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
            else map.put(ch, 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        String result = "";
        int cnt = 0;
        for(Map.Entry<Character, Integer> entry : list) {
            cnt = entry.getValue();
            while(cnt-- > 0) result += entry.getKey();
        }
        return result;
    }
}
