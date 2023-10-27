package haiwaitu.t20231027;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/10/27 23:42
 * @Description 1465. 切割后面积最大的蛋糕
 */
public class MaxArea {
    public static final int MOD = 1000 * 1000 * 1000 + 7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // 时间：O(mlogm + nlogn)，空间：O(logm + logn)
        int hMax = 0, vMax = 0;
        int m = horizontalCuts.length, n = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < m; i++) {
            int pre = i == 0 ? 0 : horizontalCuts[i - 1];
            hMax = Math.max(hMax, horizontalCuts[i] - pre);
        }
        hMax = Math.max(hMax, h - horizontalCuts[m - 1]);
        for (int i = 0; i < n; i++) {
            int pre = i == 0 ? 0 : verticalCuts[i - 1];
            vMax = Math.max(vMax, verticalCuts[i] - pre);
        }
        vMax = Math.max(vMax, w - verticalCuts[n - 1]);
        long res = (long) hMax * vMax % MOD;
        // return (int) ((long) hMax * vMax % MOD);
        return (int) res;
    }
}
