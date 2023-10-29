package haiwaitu.t20231029;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/10/29 21:23
 * @Description 274. H 指数
 */
public class HIndex {
    public int hIndex(int[] citations) {
        // 排序 时间：O(nlogn)，空间：O(logn)
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int h = Math.min(citations[i], n - i);
            res = Math.max(res, h);
        }
        return res;
    }

    public int hIndex0(int[] citations) {
        // 计数排序，时间：O(n)，空间：O(n)
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int num : citations) {
            if (num > n) {
                cnt[n]++;
            } else {
                cnt[num]++;
            }
        }
        int tot = 0;
        for (int i = n; i >= 0; i--) {
            tot += cnt[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
