package twoPointers;

import java.util.*;

public class FindLongestWord {

    public static void main(String[] args) {
        String[] strs = new String[]{"ale", "apple", "monkey", "plea"};
        List<String> list = new ArrayList<>();
        for(String str : strs) {
            list.add(str);
        }
        String result = new FindLongestWord().findLongestWord("abpcplea", list);
        System.out.println(result);
    }

    public String findLongestWord(String s, List<String> dictionary) {
        Iterator<String> iterator = dictionary.iterator();
        while(iterator.hasNext()) {
            if(!FindOrNot(s, iterator.next()))
                iterator.remove();
        }
        if(dictionary.size() == 0) return "";
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });
        return dictionary.get(0);
    }

    public boolean FindOrNot(String s, String word) {
        int i = 0, j = 0;
        while(i != s.length() && j != word.length()) {
            if(s.charAt(i) == word.charAt(j)) j++;
            i++;
        }
        if(j >= word.length()) return true;
        else return false;
    }
}
