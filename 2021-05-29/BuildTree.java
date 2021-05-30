package haiwaitu.t20210529;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/29 18:22
 * @Description 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    public Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 针对每个子区间，前序遍历数组第一个元素必定是当前子树父节点
        // 而中序遍历数组中，根节点左边的元素都属于左子树，右边的元素都属于右子树
        int len = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildCore(0, len - 1, preorder, 0, len - 1, inorder);
        return root;
    }
    public TreeNode buildCore(int preL, int preR, int[] preorder, int inL, int inR, int[] inorder) {
        if (inL > inR) {
            return null;
        }
        int val = preorder[preL];
        TreeNode node = new TreeNode(val);
        // 找到当前节点在中序数组的下标
        int idx = indexMap.get(val);
        // 计算左右子树的节点个数
        int leftNum = idx - inL;
        int rightNum = inR - idx;
        // 前序遍历中，区间[preL+1, preL+leftNum]为左子树的节点，
        // 区间[preL+leftNum+1, preR]为右子树节点
        node.left = buildCore(preL + 1, preL + leftNum, preorder, inL, idx - 1, inorder);
        node.right = buildCore(preL + leftNum + 1, preR, preorder, idx + 1, inR, inorder);
        return node;
    }
}
