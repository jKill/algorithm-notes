package haiwaitu.t20230609;

/**
 * @Author huangjunqiao
 * @Date 2023/06/09 02:42
 * @Description 1775. 通过最少操作次数使数组的和相等
 */
public class MinOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        // 哈希表+贪心。时间：O(m+n)，空间：O(m+n)
        int m = nums1.length, n = nums2.length;
        if (6 * m < n || 6 * n < m) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            cnt1[i]++;
            diff += i;
        }
        for (int i : nums2) {
            cnt2[i]++;
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        // h[i]代表对diff贡献为i(即能使diff缩小i)的数字个数
        int[] h = new int[7];
        // 统计两个数组h1、h2对diff的贡献到h中
        for (int i = 1; i <= 6; i++) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        // 从5开始贪心
        for (int i = 5; i > 0 && diff > 0; i--) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }
}
