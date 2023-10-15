package haiwaitu.t20230915;

/**
 * @Author huangjunqiao
 * @Date 2023/10/16 00:49
 * @Description 只出现一次的数字 II
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 位运算，时间：O(nlogC)，空间：O(1)。C为数字大小
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int posCnt = 0;
            for (int num : nums) {
                posCnt += (num >> i) & 1;
            }
            if (posCnt % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
