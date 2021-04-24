package haiwaitu.t20210424;

/**
 * @Author huangjunqiao
 * @Date 2021/04/24 17:05
 * @Description 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 删除倒数第N个节点，两趟扫描可以很容易的实现，但是属于暴力解法
     * 要实现一趟扫描，可以通过栈"后进先出"的特性实现，但是需要O(n)的空间
     * 更优雅的解法是双指针，只需要O(1)的空间。其中一个指针先走n步，
     * 因为是删除操作，需要记录待删除节点的前驱节点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toDelPrev = new ListNode(0);
        toDelPrev.next = head;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        // node为空说明要删除的是头节点
        if (node == null) {
            ListNode headNext = head.next;
            head.next = null;
            return headNext;
        }
        while (node != null) {
            toDelPrev = toDelPrev.next;
            node = node.next;
        }
        // 找到待删除节点，进行删除
//        ListNode toDel = toDelPrev.next;
        toDelPrev.next = toDelPrev.next.next;
        return head;
    }
}
