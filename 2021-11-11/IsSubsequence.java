package haiwaitu.t20211111;

/**
 * @Author huangjunqiao
 * @Date 2021/11/11 16:16
 * @Description 392. 判断子序列
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // 时间：O(max(M,N))，空间：O(1)
        int sLen = s.length(), tLen = t.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }
}
