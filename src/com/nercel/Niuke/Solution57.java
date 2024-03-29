package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/17
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *
 */
public class Solution57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null){
            return null;
        }
        //如果有右子树，则找右子树的最左节点
        if (pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while (pNode.next!=null){
            //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (pNode.next.left==pNode)
                return pNode.next;
            pNode=pNode.next;
        }
        //退到了根节点仍没找到，则返回null
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
