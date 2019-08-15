package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/15
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < sum; i++) {
            int num = i;
            for (int j = i + 1; j < sum; j++) {
                num += j;
                if (num < sum) {
                    continue;
                } else if (num == sum) {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    for (int m = i; m <= j; m++) {
                        array.add(m);
                    }
                    res.add(array);
                } else if (num > sum) {
                    break;
                }
            }
        }
        return res;
    }
}
