package haiwaitu.t20231030;

/**
 * @Author huangjunqiao
 * @Date 2023/10/30 22:48
 * @Description 275. H 指数 II
 */
public class HIndex2 {
    public int hIndex(int[] citations) {
        // 时间：O(logn)，空间：O(1)
        int n = citations.length;
        int idx = quickSearch(0, n - 1, citations);
        return Math.min(n - idx, citations[idx]);
    }
    public int quickSearch(int l, int r, int[] citations) {
        if (l >= r) {
            return l;
        }
        int n = citations.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (citations[mid] < n - mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
