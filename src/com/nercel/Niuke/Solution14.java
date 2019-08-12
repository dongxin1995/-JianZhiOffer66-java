package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/12
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
解题思路：

1、当输入的链表为空的时候直接返回空

2、当输入的k值大于链表的节点数的时候直接返回null；

3、先遍历链表得出链表的节点数，（注意;因为后面需要重新遍历链表查到倒数第k个节点，需要重新定义一个节点来保留head节点）

4、用节点数减去k就是链表的第几个节点，重新遍历链表找到节点返回
 */
public class Solution14 {

    public ListNode FindKthToTail(ListNode head,int k) {

        if (head==null){
            return null;
        }

        int count =1;
        ListNode old = head;
        while (head.next!=null){
            head=head.next;
            count++;
        }
        if (k>count){
            return null;
        }

        for (int i=0;i<count-k;i++){
            old=old.next;
        }

        return old;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
