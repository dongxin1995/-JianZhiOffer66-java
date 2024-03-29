package com.nercel.Niuke;

import java.util.ArrayList;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 先排序再取前K个数
 */
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (input.length <= 0 || k > input.length || k <= 0) {
            return res;
        }
        //利用冒泡算法进行排序
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j + 1] < input[j]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
}
