package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/14
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }
}
