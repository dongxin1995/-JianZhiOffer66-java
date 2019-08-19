package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dongxin
 * @create 2019/8/19
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution63 {

    ArrayList<Integer> list = new ArrayList<Integer>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        if (list.size() % 2 == 1) {
            return (double) (res[list.size() / 2]);
        } else {
            return (double) (res[list.size() / 2] + res[list.size() / 2 - 1]) / 2;
        }

    }
}
