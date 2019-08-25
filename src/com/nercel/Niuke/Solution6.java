package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {

    public int minNumberInRotateArray(int [] array) {
//        //方法1
//        if (array.length == 0)
//            return 0;
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1])
//                return array[i + 1];
//        }
//        return array[0];

        //方法2331ms
        //
        //占用内存：28052k
        if (array.length==0){
            return 0;
        }
        int low=0;
        int high = array.length-1;
        int middle=-1;
        while (low<high){
            middle=low+(high-low)/2;
            if (array[middle]>array[high]){
                low=middle+1;
            }else if (array[middle]==array[high]){
                high=high-1;
            }else {
                high=middle;
            }
        }
        return array[low];
    }

}
