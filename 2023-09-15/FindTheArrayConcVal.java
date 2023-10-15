package haiwaitu.t20230915;

/**
 * @Author huangjunqiao
 * @Date 2023/10/15 23:18
 * @Description 2562. 找出数组的串联值
 */
public class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        // 双指针，时间：O(nlogC)，空间：O:(1)。n为数组长度，C为数字大小
        int l = 0, r = nums.length - 1;
        long res = 0l;
        while (l <= r) {
            if (l == r) {
                res += nums[l];
                break;
            }
            int lNum = nums[l], rNum = nums[r];
            while (rNum != 0) {
                lNum *= 10;
                rNum /= 10;
            }
            res += (lNum + nums[r]);
            l++;
            r--;
        }
        return res;
    }
}
