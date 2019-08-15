package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/15
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树:它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class Solution39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int depth = treeDepth(root.left) - treeDepth(root.right);
        if (depth > 1 || depth < -1) {
            return false;
        } else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
