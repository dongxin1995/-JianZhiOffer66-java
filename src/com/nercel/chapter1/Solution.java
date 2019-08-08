package com.nercel.chapter1;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author dongxin
 * @create 2019/8/8
 *
 * 349
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]

示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

 */


public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num:nums1){
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num:nums2){
            if (set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;

    }

}
