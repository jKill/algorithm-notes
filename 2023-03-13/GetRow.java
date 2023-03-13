package haiwaitu.t20230313;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2023/03/14 00:46
 * @Description 119. 杨辉三角 II
 */
public class GetRow {
    public List<Integer> getRow(int n) {
        // 递推（两个数组交替）。时间：O(n^2)，空间：O(1)
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for (int i = 1; i <= n; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);

            prev = curr;
        }
        return prev;
    }
    public List<Integer> getRow0(int n) {
        // 递推（只用一个数组）。时间：O(n^2)，空间：O(1)
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= n; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public List<Integer> getRow1(int n) {
        // 线性递推，时间：O(n)，空间：O(1)
        // 根据杨辉三角性质公式，第n行第m个数:Cnm=Cnm*(n-m+1)/m
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= n; i++) {
            res.add((int) ((long) res.get(i - 1) * (n - i + 1) / i));
        }
        return res;
    }
}
