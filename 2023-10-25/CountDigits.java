package haiwaitu.t20231025;

/**
 * @Author huangjunqiao
 * @Date 2023/10/26 01:44
 * @Description 2520. 统计能整除数字的位数
 */
public class CountDigits {
    public int countDigits(int num) {
        // 模拟，时间：O(lognum)，空间：O(1)
        int curr = num;
        int res = 0;
        while (curr > 0) {
            if (num % (curr % 10) == 0) {
                res++;
            }
            curr /= 10;
        }
        return res;
    }
}
