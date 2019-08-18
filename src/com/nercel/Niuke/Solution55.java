package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/17
 *
 *
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

1.我们先看链表里是否有环，没有环的话直接null，
 */
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null||pHead.next==null){
            return null;
        }

        ListNode fast =pHead;
        ListNode slow = pHead;

        while (fast!=null||fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                fast=pHead;
                while (fast!=slow){
                    slow=slow.next;
                    fast=fast.next;
                }
                if (fast==slow){
                    return slow;
                }
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
