package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {

    public ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //由于要进行递归，所以两个arraylist还是在函数外面创建一下比较好
        if (root == null) {
            return result;
        }
        target = target - root.val;
        //用list来记录路径
        list.add(root.val);
        //判断左右子树是否全为空
        boolean isLeaf = root.left == null && root.right == null;
        if (target == 0 && isLeaf) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                path.add(list.get(i));
            }
            result.add(path);
        }

        //递归左节点
        if (target != 0 && root.left != null) {
            FindPath(root.left, target);
        }
        //递归右节点
        if (target != 0 && root.right != null) {
            FindPath(root.right, target);
        }
        //每次删除list的最后一个元素，将路径退回来，
        list.remove(list.size() - 1);
        //每次都把目前的out返回给上一次递归
        return result;


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
