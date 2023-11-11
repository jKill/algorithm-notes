package haiwaitu.t20231111;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/11/11 20:37
 * @Description
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // 双指针：O(mlogm+nlogn)，空间：O(logm+logn)
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = spells[i];
            idx[i][1] = i;
        }
        Arrays.sort(idx, (a, b) -> a[0] - b[0]);
        int j = m - 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = idx[i][1];
            while (j >= 0 && (long) idx[i][0] * potions[j] >= success) {
                j--;
            }
            res[pos]= m - 1 - j;
        }
        return res;
    }
}
