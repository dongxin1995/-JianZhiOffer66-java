package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，
 * 然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来
 */
public class Solution22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        list.add(root.val);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();

            if (node.left != null) {
                list.add(node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right.val);
                queue.add(node.right);
            }
            queue.poll();
        }
        return list;
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
