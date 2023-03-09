package haiwaitu.t20230309;

import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2023/03/09 12:12
 * @Description 120. 三角形最小路径和
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 时间：O(n^2)，空间：O(n^2)
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }

    public int minimumTotal0(List<List<Integer>> triangle) {
        // 时间：O(n^2)，空间：O(n)
        // dp[i][0] = dp[i-1][0] + c, dp[i][i] = dp[i-1][i-1]+c
        // dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1]dp[j]) + c
        // 看转移方程可知，当前dp[i][j] 只和上一层dp[i-1]元素有关，所以可以用两个一维数组代替二维数组
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int curr = i % 2;
            int prev = 1 - curr;
            dp[curr][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[curr][j] = Math.min(dp[prev][j - 1], dp[prev][j]) + triangle.get(i).get(j);
            }
            dp[curr][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        int last = (n - 1) % 2;
        int res = dp[last][0];
        for (int j = 1; j < n; j++) {
            res = Math.min(res, dp[last][j]);
        }
        return res;
    }
}
