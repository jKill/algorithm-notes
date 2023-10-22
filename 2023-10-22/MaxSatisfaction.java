package haiwaitu.t20231022;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2023/10/22 21:35
 * @Description 1402. 做菜顺序
 */
public class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        // 贪心+排序+前缀和，时间：O(nlogn)，空间：O(logn)
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (res + sum < res) {
                return res;
            }
            res += sum;
        }
        return res;
    }
}
