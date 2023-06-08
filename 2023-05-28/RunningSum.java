package haiwaitu.t20230528;

/**
 * @Author huangjunqiao
 * @Date 2023/05/28 02:32
 * @Description 1480. 一维数组的动态和
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        // 原地修改，时间；O(n)，经空间：O(1)，用时：3min
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
