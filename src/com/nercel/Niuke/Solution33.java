package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/14
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * <p>
 *
 * 解题思路：选定第一个丑数1，根据丑数的定义，可知以后的丑数必然是在1的基础上乘以2，乘以3，乘以5，因此可以得出三个丑数，
 * 从中选择最小的一个添加到list列表中，之后若list中的丑数与得出的三个丑数中的一个或两个相等，将对应的下标后移，
 *
 * https://blog.csdn.net/qq_41901915/article/details/90709893
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //对应的下标
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        list.add(1);

        while (list.size() < index) {
            int m2 = list.get(t2) * 2;
            int m3 = list.get(t3) * 3;
            int m5 = list.get(t5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);

            //若列表中存在，则对应的得出此丑数的下标后移
            if (min == m2) {
                t2++;
            }
            if (min == m3) {
                t3++;
            }
            if (min == m5) {
                t5++;
            }
        }
        return list.get(list.size()-1);
    }
}
