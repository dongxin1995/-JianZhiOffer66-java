package com.nercel.Niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongxin
 * @create 2019/8/14
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */
public class Solution36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode head = pHead1;
        Set<ListNode> res = new HashSet<ListNode>();
        while (head!=null){
            res.add(head);
            head=head.next;
        }
        head = pHead2;
        while (head!=null){
            if (res.contains(head)){
                break;
            }
            head=head.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
