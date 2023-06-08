package haiwaitu.t20230429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2023/04/29 21:40
 * @Description 131. 分割回文串
 */
public class Partition {
    boolean[][] dp;
    int n;
    List<List<String>> res = new ArrayList<>();
    List<String> subList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 回溯+动态规划，时间：n*2^n，空间：n^2
        n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (dp[idx][i]) {
                subList.add(s.substring(idx, i + 1));
                dfs(s, i + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }

    int[][] f;
    public List<List<String>> partition0(String s) {
        // 回溯+记忆化搜索，时间：n*2^n，空间：n^2
        n = s.length();
        f = new int[n][n];
        dfs0(s, 0);
        return res;
    }
    public void dfs0(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(subList));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) == 1) {
                subList.add(s.substring(i, j + 1));
                dfs0(s, j + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
