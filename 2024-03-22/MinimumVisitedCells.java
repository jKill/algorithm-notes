package haiwaitu.t20240322;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2024/03/22 23:48
 * @Description 2617. 网格图中最少访问的格子数
 */
public class MinimumVisitedCells {
    public int minimumVisitedCells(int[][] grid) {
        // 优先队列+dp，时间：O(mn(lognm + lognn))，空间：O(mn)
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[0][0] = 1;
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] col = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            row[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int j = 0; j < n; j++) {
            col[j] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j) {
                    row[i].poll();
                }
                if (!row[i].isEmpty()) {
                    dist[i][j] = update(dist[i][j], 1 + row[i].peek()[0]);
                }
                while (!col[j].isEmpty() && col[j].peek()[1] + grid[col[j].peek()[1]][j] < i) {
                    col[j].poll();
                }
                if (!col[j].isEmpty()) {
                    dist[i][j] = update(dist[i][j], 1 + col[j].peek()[0]);
                }
                if (dist[i][j] != -1) {
                    row[i].offer(new int[] {dist[i][j], j});
                    col[j].offer(new int[] {dist[i][j], i});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public int update(int x, int y) {
        return (x == -1 || y < x) ? y : x;
    }
}
