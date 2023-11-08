package haiwaitu.t20231109;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2023/11/09 02:15
 * @Description 2103. 环和杆
 */
public class CountPoints {
     public int countPoints(String rings) {
         // 暴力，时间：O(mk+nk)，空间：O(mk)，k为颜色数量，m为杆数量
         Set<Character>[] line = new Set[10];
         for (int i = 0; i < 10; i++) {
             line[i] = new HashSet<>();
         }
         int n = rings.length() / 2;
         for (int i = 0; i < n; i++) {
             int idx = rings.charAt(i * 2 + 1) - '0';
             char color = rings.charAt(i * 2);
             line[idx].add(color);
         }
         int res = 0;
         for (int i = 0; i < 10; i++) {
             if (line[i].size() == 3) {
                 res++;
             }
         }
         return res;
     }

    public int countPoints0(String s) {
        // 位运算，时间：O(m+nk)，空间：O(mk)，k为颜色数量，m为杆数量
        int[] arr = new int[10];
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i * 2 + 1) - '0';
            int color = s.charAt(i * 2);
            if (color == 'R') {
                arr[pos] |= (1 << 2);
            } else if (color == 'G') {
                arr[pos] |= (1 << 1);
            } else {
                arr[pos] |= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] == (1 << 3) - 1) {
                res++;
            }
        }
        return res;
    }
}
