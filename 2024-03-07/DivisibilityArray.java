package haiwaitu.t20240307;

/**
 * @Author huangjunqiao
 * @Date 2024/03/07 08:10
 * @Description 2575. 找出字符串的可整除数组
 */
public class DivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        // 时间：O(n)，空间：O(1)
        int n = word.length();
        long currNum = 0;
        int[] div = new int[n];
        for (int i = 0; i < n; i++) {
            int num = word.charAt(i) - '0';
            currNum = (currNum * 10 + num) % m;
            if (currNum == 0) {
                div[i] = 1;
            }
        }
        return div;
    }
}
