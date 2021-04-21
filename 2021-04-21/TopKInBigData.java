package haiwaitu.t20210421;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/04/21 15:46
 * @Description 10亿个数中如何高效地找到最大的一个数以及最大的第 K 个数
 */
public class TopKInBigData {

    public static final int BATCH = 100;

    /**
     * 假设一次只能加载1千万数据进内存，将数据均分成100批，每批通过堆筛选出前k大的数字，
     * 然后对100个批次进行归并排序，选出第k大的数
     * 堆排序log(n)，批次为p，归并排序log()
     * @param nums
     * @return
     */
    public int topK(int[] nums, int k) {
        // 1、 批次划分
        int batchLen = nums.length / BATCH;
        int[][] allBatches = new int[BATCH][batchLen];
        for (int i = 0; i < BATCH; i++) {
            int[] subNums = new int[batchLen];
            for (int j = 0; j < batchLen; j++) {
                subNums[j] = nums[i * batchLen + j];
            }
            allBatches[i] = subNums;
        }
        // 2、堆排序筛选出每个批次前k大
        PriorityQueue[] queues = new PriorityQueue[BATCH];
        for (int i = 0; i < BATCH; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int num : allBatches[i]) {
                if (queue.size() >= k) {
                    queue.poll();
                }
                queue.add(num);
            }
            queues[i] = queue;
        }
        // 3、归并排序，找出第k大
        int result = Integer.MIN_VALUE;
        return result;
    }

    public int max(int[] nums) {
        // 1、 批次划分
        int batchLen = nums.length / BATCH;
        int[][] allBatches = new int[BATCH][batchLen];
        for (int i = 0; i < BATCH; i++) {
            int[] subNums = new int[batchLen];
            for (int j = 0; j < batchLen; j++) {
                subNums[j] = nums[i * batchLen + j];
            }
            allBatches[i] = subNums;
        }
        // 2、计算最大值
        int max = Integer.MIN_VALUE;
        for (int[] batch : allBatches) {
            for (int num : batch) {
                max = num > max ? num : max;
            }
        }
        return max;
    }


    public static void main(String[] args) {

    }
}
