package haiwaitu.t20210530;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/30 17:26
 * @Description 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTreePost {
    static Map<Integer, Integer> indexMap;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 递归解法
        int len = inorder.length;
        indexMap = new HashMap<>();
        // 方便根据值获取节点在后序遍历数组中的位置
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildCore(0, len - 1, inorder, 0, len - 1, postorder);
    }
    public static TreeNode buildCore(int inL, int inR, int[] inorder, int postL, int postR, int[] postorder) {
        if (inL > inR) {
            return null;
        }
        int val = postorder[postR];
        TreeNode node = new TreeNode(val);
        // 根据值获取当前节点中序遍历数组中的位置
        int idx = indexMap.get(val);
        // 计算右子树的节点个数
        int rightNum = inR - idx;
        // 中序遍历数组中，[inL, idx-1]为左子树节点，[idx+1, inR]为右子树节点
        // 后序遍历数组中，[postR-rightNum, postR]为右子树节点，[postL,postR-rightNum-1]为左子树节点
        node.left = buildCore(inL, idx - 1, inorder, postL, postR - rightNum - 1, postorder);
        node.right = buildCore(idx + 1, inR, inorder, postR - rightNum, postR - 1, postorder);
        return node;
    }

    public TreeNode buildTree0(int[] inorder, int[] postorder) {
        // 迭代解法
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        System.out.println(buildTree(inorder, postorder));
    }

}
