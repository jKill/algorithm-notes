package haiwaitu.t20210425;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/04/25 11:44
 * @Description 112. 路径总和
 */
public class HasPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 广度优先搜索BFS
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int currVal = valQueue.poll();
            if (currNode.left == null && currNode. right == null) {
                if (currVal == targetSum) {
                    return true;
                } else {
                    continue;
                }
            }
            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
                valQueue.offer(currVal + currNode.left.val);
            }
            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
                valQueue.offer(currVal + currNode.right.val);
            }
        }
        return false;
    }
}
