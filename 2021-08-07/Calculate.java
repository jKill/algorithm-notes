package haiwaitu.t20210807;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/10 00:17
 * @Description 227. 基本计算器 II
 */
public class Calculate {
    public int calculate(String s) {
        // 栈，时间：O(N)，空间：O(N)
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 如果当前字符为+ - * /，计算前面字符的运算结果
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                if ('+' == preSign) {
                    stack.push(num);
                } else if ('-' == preSign) {
                    stack.push(-num);
                } else if ('*' == preSign) {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                preSign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
