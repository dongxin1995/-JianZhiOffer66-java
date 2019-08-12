package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/12
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                list.next = list2;
                list = list.next;
                list2 = list2.next;
            } else {
                list.next = list1;
                list = list.next;
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            list.next = list1;
            list = list.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            list.next = list2;
            list = list.next;
            list2 = list2.next;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
