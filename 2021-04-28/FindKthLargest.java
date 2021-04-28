package haiwaitu.t20210428;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2021/04/28 21:58
 * @Description 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    static Random rand = new Random();

    public static int findKthLargest(int[] nums, int k) {
        // 基于小顶堆
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        // 堆大小维持在k
//        for (int num : nums) {
//            if (queue.size() < k) {
//                queue.offer(num);
//            } else if (num >= queue.peek()) {
//                queue.poll();
//                queue.offer(num);
//            }
//        }
//        return queue.peek();

        // 基于快排，快排的partition方法每次都会把选中的数字放在合适的位置，左右都是比他大或小的数，
        // 利用这个特性可以找到第k位的数字，即可结束递归，不需要把整个数组都排序
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int quickSelect(int[] nums, int start, int end, int k) {
        int idx = partition(nums, start, end);
        if (idx == k - 1) {
            return nums[idx];
        } else if (idx < k - 1) {
            return quickSelect(nums, idx + 1, end, k);
        } else {
            return quickSelect(nums, start, idx - 1, k);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int idx = start + rand.nextInt(end - start + 1);
        swap(nums, idx, end);
        int pos = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[end]) {
                swap(nums, i, pos);
                pos++;
            }
        }
        swap(nums, end, pos);
        return pos;
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] n = {3,2,1,5,6,4};
        System.out.println(findKthLargest(n, 2));
    }

}
