package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/16
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution51 {
    public int[] multiply(int[] A) {
        if (A==null||A.length==0){
            return null;
        }
        int[] B = new int[A.length];
        for (int i=0;i<A.length;i++){
            B[i]=1;
            for (int j =0;j<A.length;j++){
                if (j!=i){
                    B[i]*=A[j];
                }
            }
        }
        return B;
    }
}
