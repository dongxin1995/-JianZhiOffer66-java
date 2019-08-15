package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/15
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 */
public class Solution40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        // a，b记录下标
        int a = -1;
        int b = -1;
        int count = 1;// 记录出现的次数
        for (int i = 0; i < array.length; i++) {
            count = 1;
            // 遍历一遍，出现两次的情况
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    count++;
                }
            }
            // 内层遍历后，如果count仍旧是1，那么说下标赋值
            if (count == 1) {
                if (a == -1) {
                    a = i;
                } else {
                    b = i;
                }
            }
        }
        num1[0] = array[a];
        num2[0] = array[b];
    }
}
