package com.nercel.Niuke;

import java.util.Stack;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * <p>
 * data栈 依次入栈元素 5,   4,   3,   8,   10,   11,   12,   1；
 * <p>
 * min栈 依次入栈元素 5， 4,   3，3,    3，  3，   3， 1。
 * <p>
 * 出栈时，min的栈与栈data均要出栈
 */
public class Solution20 {

    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            //压入最小值
            min.push(node);
        } else {
            //当压入的结点大时，则每次都压入min栈顶的值。
            min.push(min.peek());
        }

    }

    public void pop() {
        //出栈时，min栈和data栈均出栈
        if (data.peek()!=min.peek()){
            data.pop();
        }else {
            data.pop();
            min.pop();
        }

    }

    public int top() {
        return data.peek();

    }

    public int min() {
        return min.peek();
    }
}
