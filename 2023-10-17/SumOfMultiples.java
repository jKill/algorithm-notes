package haiwaitu.t20230917;

/**
 * @Author huangjunqiao
 * @Date 2023/10/17 23:23
 * @Description 2652. 倍数求和
 */
public class SumOfMultiples {
    public int sumOfMultiples(int n) {
        // 枚举，时间：O(n)，空间：O(1)
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
