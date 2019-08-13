package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/13
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *  原文链接:https://blog.csdn.net/qq_41901915/article/details/90286802
 */
public class Solution25 {

    public RandomListNode Clone(RandomListNode pHead) {
        while (pHead==null){
            return null;
        }

        RandomListNode cur = pHead;
        //插入相同的节点
        while (cur!=null){
            //每次都需要创建一个节点与前面的内容相同
            RandomListNode clone1= new RandomListNode(cur.label);
            //复制过程，其实就是插入一个重复的内容
            clone1.next=cur.next;
            cur.next=clone1;
            //将指针往后移动，继续循环
            cur=clone1.next;
        }
        //插入随机指针
        //将cur重新指向头
        cur=pHead;
        while (cur!=null){
            RandomListNode clone2 = cur.next;
            if (cur.random!=null){
                clone2.random=cur.random.next;
            }
            cur=clone2.next;
        }
        //拆分
        cur=pHead;
        RandomListNode resultNode = cur.next;
        while (cur.next!=null){
            RandomListNode clone3=cur.next;
            cur.next=clone3.next;
            cur=clone3;
        }
        return resultNode;
    }


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
