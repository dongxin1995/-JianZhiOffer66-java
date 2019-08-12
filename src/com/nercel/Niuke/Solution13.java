package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongxin
 * @create 2019/8/12
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class Solution13 {

    public void reOrderArray(int [] array) {

        List<Integer> odd= new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();

        int temp=0;
        for (int i=0;i<array.length;i++){
            temp = array[i];
            if (temp%2==0){
                even.add(temp);
            }else {
                odd.add(temp);
            }
        }

        int m =0;
        for (int i=0;i<odd.size();i++){
            array[m]=odd.get(i);
            m++;
        }
        for (int j=0;j<even.size();j++){
            array[m]=even.get(j);
            m++;
        }

    }
}
