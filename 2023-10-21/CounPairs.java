package haiwaitu.t20230921;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/10/21 16:32
 * @Description 2316. 统计无向图中无法互相到达点对数
 */
public class CounPairs {
    // List<List<Integer>> graph = new ArrayList<>();
    // boolean[] visited;
    // public long countPairs(int n, int[][] edges) {
    //     // DFS，时间：O(m+n)，空间：O(m+n)，m为边数
    //     visited = new boolean[n];
    //     for (int i = 0; i < n; i++) {
    //         graph.add(new ArrayList<>());
    //     }
    //     for (int[] edge : edges) {
    //         graph.get(edge[0]).add(edge[1]);
    //         graph.get(edge[1]).add(edge[0]);
    //     }

    //     long res = 0, reached = 0;
    //     for (int i = 0; i < n; i++) {
    //         int curr = dfs(i);
    //         res += reached * curr;
    //         reached += curr;
    //     }

    //     return res;
    // }

    // public int dfs(int i) {
    //     if (visited[i]) {
    //         return 0;
    //     }
    //     visited[i] = true;
    //     int cnt = 1;
    //     for (int p : graph.get(i)) {
    //         cnt += dfs(p);
    //     }
    //     return cnt;
    // }

    public long countPairs(int n, int[][] edges) {
        // 并查集，将连同的点作为并查集的一个集合，遍历每个点，查询能到达的点数量s，n-s为无法到达的点数量，所有点的这个数字求和，则为答案的两倍。时间：(m+n)a，空间：O(n)，a为阿克曼函数的反函数
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n - uf.sizes[uf.find(i)];
        }
        return res / 2;
    }

    class UnionFind {

        public int[] sizes;
        private int[] parent;
        public UnionFind(int n) {
            sizes = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(sizes, 1);
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            // 把小集合合并到大集合上
            if (xRoot != yRoot) {
                if (sizes[xRoot] > sizes[yRoot]) {
                    parent[yRoot] = parent[xRoot];
                    sizes[xRoot] += sizes[yRoot];
                } else {
                    parent[xRoot] = parent[yRoot];
                    sizes[yRoot] += sizes[xRoot];
                }
            }
        }
    }
}
