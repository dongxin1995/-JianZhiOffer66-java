package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/16
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class Solution47 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }
}
