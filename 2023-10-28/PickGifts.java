package haiwaitu.t20231028;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2023/10/28 16:50
 * @Description 2558. 从数量最多的堆取走礼物
 */
public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        // 最大堆，时间：O(klogn)，空间：O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            pq.offer((int) Math.sqrt(max));
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
