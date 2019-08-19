package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/18
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * <p>
 * 中序遍历二叉搜索树后正好是从小到大的顺序，直接返回第k-1个即可
 */
public class Solution62 {

    ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        InOrder(pRoot);
        if (treeNodes.size() < 1 || k < 1 || k > treeNodes.size()) {
            return null;
        }
        return treeNodes.get(k - 1);
    }

    private void InOrder(TreeNode node) {
        if (node != null) {
            InOrder(node.left);
            treeNodes.add(node);
            InOrder(node.right);
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
