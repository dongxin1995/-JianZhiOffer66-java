package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
斐波那契数列

F(1) = 1,F(2) = 1, F(3) = F(1) + F(2)...... Fn = F(n-2) + F(n-1)
 */
public class Solution7 {

    public int Fibonacci(int n) {
        int a = 1, b = 1;
        int val = 0;
        if (n == 1 | n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            val = a + b;
            a = b;
            b = val;
        }
        return val;
    }

}
