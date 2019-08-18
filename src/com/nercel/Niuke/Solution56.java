package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/17
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 */
public class Solution56 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null){
            return null;
        }
        if (pHead.next==null){
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=pHead;
        ListNode cur= dummyHead.next;
        while (cur.next!=null&&cur.next.next!=null){
            if (cur.next.val==cur.next.next.val){
                ListNode temp =cur.next.next;
                while (temp.next!=null&&temp.next.val==temp.val){
                    temp=temp.next;
                }
                temp=temp.next;
                cur.next=temp;
            }else {
                cur=cur.next;
            }

        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
