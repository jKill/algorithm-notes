package haiwaitu.t20211020;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/10/20 14:27
 * @Description 200. 岛屿数量
 */
public class NumIslands {
     public int numIslands(char[][] grid) {
         // dfs，将访问过的'1'置为'0'，遇到'0'终止dfs。这样每次dfs都能完整遍历完一个岛屿，最终岛屿数量等于dfs次数。时间：每个节点访问一次，O(MN)，空间：最坏情况下全是陆地，调用栈深度MN，O(MN)
         int islandNum = 0;
         int m = grid.length, n = grid[0].length;
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (grid[i][j] == '1') {// 发现新岛屿
                     islandNum++;
                     dfs(i, j, grid);
                 }
             }
         }
         return islandNum;
     }
     public void dfs(int i, int j, char[][] grid) {
         if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
             return;
         }
         grid[i][j] = '0';
         dfs(i + 1, j, grid);
         dfs(i - 1, j, grid);
         dfs(i, j + 1, grid);
         dfs(i, j - 1, grid);
     }

     public int numIslands0(char[][] grid) {
         // bfs，标记思路与dfs一样，区别是搜索过程改为bfs。每个节点访问一次。时间：O(MN)
         int islandNum = 0;
         int m = grid.length;
         int n = grid[0].length;
         Deque<int[]> q = new LinkedList<>();
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (grid[i][j] == '1') {
                     islandNum++;
                     grid[i][j] = '0';
                     q.offer(new int[] {i, j});
                     while (!q.isEmpty()) {
                         int[] pos = q.poll();
                         int x = pos[0], y = pos[1];
                         if (x + 1 < m && grid[x + 1][y] == '1') {
                             grid[x + 1][y] = '0';
                             q.offer(new int[] {x + 1, y});
                         }
                         if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                             grid[x - 1][y] = '0';
                             q.offer(new int[] {x - 1, y});
                         }
                         if (y + 1 < n && grid[x][y + 1] == '1') {
                             grid[x][y + 1] = '0';
                             q.offer(new int[] {x, y + 1});
                         }
                         if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                             grid[x][y - 1] = '0';
                             q.offer(new int[] {x, y - 1});
                         }
                     }
                 }
             }
         }
         return islandNum;
     }

}
