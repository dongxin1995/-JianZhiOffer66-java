package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/13
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *
 */
public class Solution28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0){
            return 0;
        }

        for (int i =0;i<array.length;i++){
            int count =0;
            for (int j=0;j<array.length;j++){
                if (array[i]==array[j]){
                    count++;
                }
            }
            if (count>(array.length/2)){
                return array[i];
            }
        }
        return 0;
    }
}
