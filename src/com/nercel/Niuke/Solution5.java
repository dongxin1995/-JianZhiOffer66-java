package com.nercel.Niuke;

import java.util.Stack;

/**
 * @author dongxin
 * @create 2019/8/8
 * <p>
 * 两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int val;
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        try {
            if (stack2.empty()) {
                throw new Exception("队列为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        val = stack2.pop();
        return val;
    }
}
