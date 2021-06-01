package haiwaitu.t20210531;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/01 14:37
 * @Description 114. 二叉树展开为链表
 */
public class Flatten {
     public void flatten(TreeNode root) {
         // 非主流解法，原地递归，时间O(n)，空间O(n)
         flattenCore(root);
         return;
     }
     public TreeNode flattenCore(TreeNode node) {
         // 先处理左子节点
         if (node.left != null) {
             // 缓存右子节点，左子节点移到右边并递归处理，处理后最右边的节点rightPrev拼接到原来的右子节点前面
             TreeNode originRight = node.right;
             node.right = node.left;
             node.left = null;
             TreeNode rightPrev = flattenCore(node.right);
             // 最右边的节点rightPrev接上原来的右节点
             rightPrev.right = originRight;
             // 节点指向处理完的最后一个节点
             node = rightPrev;
         }
         // 处理右子节点
         if (node.right != null) {
             node = flattenCore(node.right);
         }
         return node;
     }

    public void flatten0(TreeNode root) {
        // 原地前驱指针迭代，时间O(n)，空间O(1)
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.left != null) {
                prev = curr.left;
                // 找到左子节点的最右子节点prev
                while (prev.right != null) {
                    prev = prev.right;
                }
                // 把当前右子节点拼接到prev后面
                prev.right = curr.right;
                // 当前左子节点移到右子节点的位置
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
