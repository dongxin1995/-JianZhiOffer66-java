package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/12
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 */

public class Solution15 {
    //反转链表，就是反转链表节点的指针的指向，这里需要三个节点才能保证反转之后能继续往下移动
    public ListNode ReverseList(ListNode head) {

        //只有一个节点的时候，头结点就是反转节点的头结点
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }

        //表示反转链表的头结点
        ListNode reverseHead = null;
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;

        while (curNode!=null){
            //nextNode节点为curNode的下一个节点
            nextNode=curNode.next;
            if (nextNode==null){
                reverseHead=curNode;//如果下一个节点为null，则表示当前节点为原链表的末尾节点
            }
            curNode.next=preNode;//开始反转，让当前节点指向它的之前的节点
            preNode=curNode;//让之前的节点指向当前节点
            curNode=nextNode;//当前节点指向下一个节点：while循环里的第一句就是让这下一个节点继续向下走一步
        }
        return reverseHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
