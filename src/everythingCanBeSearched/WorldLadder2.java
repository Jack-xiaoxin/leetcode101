package everythingCanBeSearched;

import java.util.*;

public class WorldLadder2 {

    public static void main(String[] args) {
        List<String> worldList = new ArrayList<>();
        worldList.add("hot");
        worldList.add("dot");
        worldList.add("dog");
        worldList.add("lot");
        worldList.add("log");
        worldList.add("cog");
        new WorldLadder2().findLadders("hit", "cog", worldList);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int wordLen = beginWord.length();
        queue.offer(beginWord);
        dict.remove(beginWord);
        int step = 1;
        boolean isFound = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] curArray = curWord.toCharArray();
                for(int j = 0; j < wordLen; j++) {
                    char curChar = curArray[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        curArray[j] = ch;
                        String nextWord = String.valueOf(curArray);
                        if(steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(curWord);
                        }
                        if(!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        steps.put(nextWord, step);
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(curWord);
                    }
                    curArray[j] = curChar;
                }
                if(!dict.contains(endWord)) isFound = true;
            }
            step++;
            if(isFound) break;
        }

        if(isFound) {
            Deque<String> path = new ArrayDeque<>();
            DFS(endWord, beginWord, from, path, res);
        }

        return res;

    }

    public void DFS(String curWord, String beginWord, Map<String, List<String>> from, Deque<String> path, List<List<String>> res) {
        path.addFirst(curWord);
        if(curWord.equals(beginWord)) res.add(new ArrayList<>(path));
        else{
            for(String str : from.get(curWord)) {
                DFS(str, beginWord, from, path, res);
            }
        }
        path.pollFirst();
    }
}
