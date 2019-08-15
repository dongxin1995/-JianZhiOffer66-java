package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/15
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * <p>
 * 可以把需要左旋的字符串看成一部分，其他的字符串看成另一部分，比如字符串“abcdef”，需要输出左移2位的结果，
 * 可以把字符串“ab”看成一部分，字符串“cdef”看成另一部分，仍然使用上一题中reverse函数，先翻转“ab”得到“ba”，
 * 再翻转”cdef“得到”fedc“，两个字符串租在一起之后是”bafedc“，最后对整个字符串进行一次翻转得到”cdefab“，
 * 刚好是原来字符串左旋2位之后的结果。
 */
public class Solution43 {

    public String LeftRotateString(String str, int n) {
        if (str.length() == 0 || str == null) {
            return str;
        }

        char[] chars = str.toCharArray();
        int firsStart = 0;
        int firstEnd = n - 1;
        int secondStart = n;
        int secondEnd = chars.length - 1;
        reverse(chars, firsStart, firstEnd);
        reverse(chars, secondStart, secondEnd);
        reverse(chars, firsStart, secondEnd);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
