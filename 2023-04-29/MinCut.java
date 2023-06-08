package haiwaitu.t20230429;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/04/29 12:18
 * @Description 132. 分割回文串 II
 */
public class MinCut {
    public int minCut(String s) {
        // 动态规划，时间：O(n^2)，空间：O(n^2)
        // f[i][j]表示s[i,j]是否回文
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        // g[i]表示s[0,i]需要的最小分割次数，如果s[j+1,i]是回文，那么g[i]可以由g[j]转移而来，即g[i]=g[j]+1
        int[] g = new int[n];
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                g[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        g[i] = Math.min(g[i], g[j] + 1);
                    }
                }
            }
        }
        return g[n - 1];
    }
}
