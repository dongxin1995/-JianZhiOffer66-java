package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongxin
 * @create 2019/8/17
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * arraylist的方法

    add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常

    linkedlist的方法
　　offer       添加一个元素并返回true       如果队列已满，则返回false
　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
　　peek       返回队列头部的元素             如果队列为空，则返回null


　　put         添加一个元素                      如果队列满，则阻塞
　　take        移除并返回队列头部的元素     如果队列为空，则阻塞

https://blog.csdn.net/qq_41901915/article/details/90415691
 *
 */
public class Solution60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot==null){
            return result;
        }

        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        //用一个辅助队列来进行层次遍历
        //用start和end进行分层，一旦达到end就重置start为0，end为当前队列大小
        int start = 0,end =1;
        while (!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if (cur.left!=null){
                layer.add(cur.left);
            }
            if (cur.right!=null){
                layer.add(cur.right);
            }
            //如果相等的话，这一层就完事了，那么就重新设定start和end
            if (start==end){
                end=layer.size();
                start=0;
                result.add(layerList);
                layerList=new ArrayList<Integer>();
            }
        }
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
