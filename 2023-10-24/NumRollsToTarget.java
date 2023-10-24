package haiwaitu.t20231024;

/**
 * @Author huangjunqiao
 * @Date 2023/10/24 23:54
 * @Description 1155. 掷骰子等于目标和的方法数
 */
public class NumRollsToTarget {
    static final int MOD = 1000 * 1000 * 1000 + 7;
    long cnt = 0;
    // public int numRollsToTarget(int n, int k, int target) {
    //     // dp，记f(i,j)为i个骰子和为j的方案数，设最后一个骰子的值为x，状态转移方程为 f[i][j] = f[i-1][j-x]，时间：O(n*k*target)，空间：O(n*target)
    //     int[][] f = new int[n + 1][target + 1];
    //     f[0][0] = 1;
    //     for (int i = 1; i <= n; i++) {
    //         for (int j = 1; j <= target; j++) {
    //             for (int x = 1; x <= k; x++) {
    //                 if (j - x >= 0) {
    //                     f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
    //                 }
    //             }
    //         }
    //     }
    //     return f[n][target];
    // }

    public int numRollsToTarget(int n, int k, int target) {
        // 用滚动数组优化的dp，时间：O(n*k*target)，空间：O(n)
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                f[j] = 0;// 清零
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        f[j] = (f[j] + f[j - x]) % MOD;
                    }
                }
            }
        }
        return f[target];
    }
}
