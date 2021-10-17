package haiwaitu.t20211016;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/10/17 17:12
 * @Description 127. 单词接龙
 */
public class LadderLength {
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeId = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs，时间:O(NC*C)，空间：O(NC*C)，N为单词数量，C为字符长度
        for (String word : wordList) {
            addEdge(word);
        }
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        addEdge(beginWord);

        int[] steps = new int[nodeId];
        Arrays.fill(steps, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);;
        steps[beginId] = 0;

        Deque<Integer> q = new LinkedList<>();
        q.offer(beginId);
        while (!q.isEmpty()) {
            int currId = q.poll();
            if (endId == currId) {
                // 每跳到下一个节点前，都需要经过一个虚拟节点
                return steps[endId] / 2 + 1;
            }
            for (int nextId : edge.get(currId)) {

                if (Integer.MAX_VALUE == steps[nextId]) {// 只初始化的时候赋值一次步数，防止走“回头路”
                    steps[nextId] = steps[currId] + 1;
                    q.offer(nextId);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id = wordId.get(word);
        char[] arr = word.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            char temp = arr[i];
            arr[i] = '*';
            String vNode = new String(arr);//创建虚拟节点
            addWord(vNode);

            int newId = wordId.get(vNode);
            edge.get(id).add(newId);
            edge.get(newId).add(id);
            arr[i] = temp;
        }
    }
    public void addWord(String word) {
        if (wordId.containsKey(word)) {
            return;
        }
        wordId.put(word, nodeId++);
        edge.add(new ArrayList<>());
    }
}
