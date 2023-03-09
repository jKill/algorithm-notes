package haiwaitu.t20230309;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2023/03/09 12:13
 * @Description 118. 杨辉三角
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        // 时间：O(n^2)，空间：O(n^2)
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    List<Integer> pre = res.get(i - 1);
                    curr.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(curr);
        }
        return res;
    }
}
