package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author dongxin
 * @create 2019/8/17
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *  按之字形顺序打印二叉树需要两个栈。我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。如果当前打印的是奇数层，
 *  则先保存子结点再保存右子结点到一个栈里；如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 *
 */
public class Solution59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> arrayListAllLevel = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return arrayListAllLevel;
        //stack1暂存奇数层结点
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        //stack2暂存偶数层结点
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        //初始层为第一层
        int level = 1;
        //将第一层的结点按从左到右的顺序入栈
        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            //保存该层中栈的元素
            ArrayList<Integer> arrayListlevel = new ArrayList<Integer>();
            //判断是哪一个栈进行出栈操作
            if (level % 2 == 1) {
                //当奇数层执行出栈操作时
                //如果stack1还存在元素，则继续出栈
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    //在出栈的同时，将此节点的左右子节点入stack2
                    //同时存入另一个栈的顺序是先存左子节点，再存右子节点
                    arrayListlevel.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                level++;
                //stack1中所有元素出栈完毕后，将奇数层次的所有元素加入到整个线性表中
                arrayListAllLevel.add(arrayListlevel);
            } else {
                //stack2执行出栈操作
                //当偶数层执行出栈操作时
                //如果stack2还存在元素，则继续出栈
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    //出栈同时加入到奇数层次的数组中
                    arrayListlevel.add(node.val);
                    //在出栈的同时，将此节点的左右子节点入stack1
                    //同时存入另一个栈的顺序是先存右子节点，再存左子节点
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                level++;
                //stack2中所有元素出栈完毕后，将偶数层次的所有元素加入到整个线性表中
                arrayListAllLevel.add(arrayListlevel);
            }
        }
        return arrayListAllLevel;
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
//    /**
//     * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
//     * 在海量数据时，这样效率太低了。
//     * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
//     * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
//     *
//     * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
//     * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
//     *     1)可用做队列,实现树的层次遍历
//     *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
//     */
//    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//        if (pRoot == null) {
//            return ret;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.addLast(null);//层分隔符
//        queue.addLast(pRoot);
//        boolean leftToRight = true;
//
//        while (queue.size() != 1) {
//            TreeNode node = queue.removeFirst();
//            if (node == null) {//到达层分隔符
//                Iterator<TreeNode> iter = null;
//                if (leftToRight) {
//                    iter = queue.iterator();//从前往后遍历
//                } else {
//                    iter = queue.descendingIterator();//从后往前遍历
//                }
//                leftToRight = !leftToRight;
//                while (iter.hasNext()) {
//                    TreeNode temp = (TreeNode)iter.next();
//                    list.add(temp.val);
//                }
//                ret.add(new ArrayList<Integer>(list));
//                list.clear();
//                queue.addLast(null);//添加层分隔符
//                continue;//一定要continue
//            }
//            if (node.left != null) {
//                queue.addLast(node.left);
//            }
//            if (node.right != null) {
//                queue.addLast(node.right);
//            }
//        }
//
//        return ret;
//    }