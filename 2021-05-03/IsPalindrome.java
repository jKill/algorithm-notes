package haiwaitu.t20210503;

/**
 * @Author huangjunqiao
 * @Date 2021/05/03 22:03
 * @Description 125. 验证回文串
 */
public class IsPalindrome {
    /**
     * 使用指针A指向字符串开头，指针B指向字符串末尾，
     * A从前往后扫描，B从后往前扫描，跳过不合法字符后如果两
     * 指针指向的字符不想等，则不是回文，否则是回文
     * 不用JDK的Character.isLetterOrDigit()和Character.toUppserCase()等
     * API（击败60%~80%）而是自己实现（击败99.86%）是因为这样更快，不用像JDK考虑各种情况
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        char lChar;
        char rChar;
        while (l < r && l >= 0 && r < s.length()) {
            lChar = s.charAt(l);
            rChar = s.charAt(r);
            // 跳过不合法的字符
            if (!isLegalChar(lChar)) {
                l++;
                continue;
            }
            if (!isLegalChar(rChar)) {
                r--;
                continue;
            }
            // 如果两边的字符都合法，比较是否相等，不相等说明不是回文，返回false；
            if (!cEqualsIngoreCases(lChar, rChar)) {
                return false;
            }
            // 相等继续比较下一个字符
            l++;
            r--;
        }
        return true;
    }

    public static boolean isLegalChar(char c) {
        // 判断字符是否合法，可以是小写子母，大写字母或者数字
        return isLowercase(c) || isUpperCase(c) || isNum(c);
    }
    public static boolean cEqualsIngoreCases(char c1, char c2) {
        // 判断两数字是否相等（忽略大小写）
        // 同一个字母，大写字母的ascii值比小写字母的ascii值小22
        if (isLowercase(c1) && isUpperCase(c2)) {
            return c1 - 32 == c2;
        }
        if (isUpperCase(c1) && isLowercase(c2)) {
            return c2 - 32 == c1;
        }
        return c1 == c2;
    }
    public static boolean isLowercase(char c) {
        // 是否小写字母
        return c >= 97 && c <= 122;
    }
    public static boolean isUpperCase(char c) {
        // 是否大写字母
        return c >= 65 && c <= 90;
    }
    public static boolean isNum(char c) {
        // 是否数组
        return c >= 48 && c <= 57;
    }
}
