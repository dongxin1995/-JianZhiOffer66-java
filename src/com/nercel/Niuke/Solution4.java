package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //这里是判断结束的标志，由于是递归算法，我们不可能一直执行下去，所以需要结束标志
        //下面这两种情况发生一个就会结束
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }
        //首先找到根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //对中序遍历进行查找根节点
        for (int i= inStart;i<=inEnd;i++){
            if (in[i]==pre[preStart]){
                //重建二叉树的关键就是找到其中的边界值
                root.left=reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=reConstructBinaryTree(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;

    }
}
