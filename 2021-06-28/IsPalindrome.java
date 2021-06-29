package haiwaitu.t20210628;

import haiwaitu.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/06/29 15:51
 * @Description 234. 回文链表
 */
public class IsPalindrome {
    ListNode lNode;
    public boolean isPalindrome(ListNode head) {
        // 递归解法，时间O(N)，空间O(N)
        lNode = head;
        return isCore(head);
    }
    boolean isCore(ListNode rNode) {
        if (rNode == null) {
            return true;
        }
        boolean isPalidrome = isCore(rNode.next) && lNode.val == rNode.val;
        lNode = lNode.next;
        return isPalidrome;
    }

    public boolean isPalindrome0(ListNode head) {
        // 线性表，时间O(N)，空间O(N)
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int len = list.size();
        int l = 0, r = len - 1;
        while (l < r) {
            if (list.get(l).val != list.get(r).val) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
