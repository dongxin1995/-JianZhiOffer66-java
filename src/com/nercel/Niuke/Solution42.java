package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/15
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                break;
            }
            while (array[i] + array[j] > sum) {
                j--;
            }
            while (array[i] + array[j] < sum) {
                i++;
            }
        }
        return res;
    }
}
