package haiwaitu.t20210806;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @Author huangjunqiao
 * @Date 2021/08/06 21:55
 * @Description 456. 132 模式
 */
public class Find132Pattern {
     public boolean find132pattern(int[] nums) {
         // 枚举3，时间：O(NlogN)，空间O(N)
         int len = nums.length;
         if (len < 3) {
             return false;
         }
         TreeMap<Integer, Integer> map = new TreeMap<>();
         for (int k = 2; k < len; k++) {
             map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
         }
         int leftMin = nums[0];
         for (int j = 1; j < len - 1; j++) {
             if (nums[j] > leftMin) {
                 Integer kNum = map.ceilingKey(leftMin + 1);
                 if (kNum != null && nums[j] > kNum) {
                     return true;
                 }
             }
             leftMin = Math.min(leftMin, nums[j]);
             map.put(nums[j + 1], map.get(nums[j + 1]) - 1);
             if (map.get(nums[j + 1]) == 0) {
                 map.remove(nums[j + 1]);
             }
         }
         return false;
     }

    public boolean find132pattern0(int[] nums) {
        // 维护单调栈，栈顶到栈底单调递增，从后往前遍历数组时，弹出去的最大数可以作为k，由于
        // 栈顶比k大，可以作为j，接下来只要找到比k小的数作为i即可。时间：O(N)，空间：O(N)
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[len - 1]);
        int maxK = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                maxK = stack.pop();
            }
            // 比k大的nums[i]可以作为j（放到栈顶）
            if (nums[i] > maxK) {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
