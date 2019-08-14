package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/14
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 *
 * https://blog.csdn.net/qq_27139155/article/details/79517668
 */
public class Solution31 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int num=0;
        if(n<=0)
            return 0;
        //base表示当年分析的是哪一个数位，原理还是通过个十百千万位来算1的个数
        //但是考虑时间复杂度的话不能暴力解算，用一种统计的思想去做这道题目
        int yushu;
        int shang=n;
        int base=1;
        while(shang!=0){
            yushu=shang%10;
            shang=shang/10;
            if(yushu==0){
                num+=shang*base;
            }else if(yushu==1){
                num+=shang*base+n-n/base*base+1;
            }else{
                num+=(shang+1)*base;
            }
            base*=10;
        }


        return num;
    }
}
