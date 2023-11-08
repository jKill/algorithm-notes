package haiwaitu.t20231109;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2023/11/09 02:17
 * @Description 2003. 每棵子树内缺失的最小基因值
 */
public class SmallestMissingValueSubtree {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        // DFS+启发式合并
        int n = nums.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }

        Set<Integer>[] geneSet = new Set[n];
        for (int i = 0; i < n; i++) {
            geneSet[i] = new HashSet<>();
        }

        int[] res = new int[n];
        Arrays.fill(res, 1);
        dfs(0, nums, res, geneSet, children);
        return res;
    }

    public int dfs(int node, int[] nums, int[] res, Set<Integer>[] geneSet, List<Integer>[] children) {
        geneSet[node].add(nums[node]);
        for (int child : children[node]) {
            // 由于缺失值>=任一子树的缺失值，可以初始化为子树缺失值中最大的那个，有助于减少超时case
            res[node] = Math.max(res[node], dfs(child, nums, res, geneSet, children));
            if (geneSet[node].size() < geneSet[child].size()) {
                Set<Integer> temp = geneSet[node];
                geneSet[node] = geneSet[child];
                geneSet[child] = temp;
            }
            geneSet[node].addAll(geneSet[child]);
        }
        while (geneSet[node].contains(res[node])) {
            res[node]++;
        }
        return res[node];
    }
}
