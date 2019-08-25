package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {

        int rowCount = array.length;
        int colCount = array[0].length;
        int i=0 ;
        int j =colCount-1;
        while (i<rowCount&&j>=0){
            if (target==array[i][j]){
                return true;
            }
            else if (target>array[i][j]){
                i++;
                continue;
            }else if (target<array[i][j]){
                j--;
                continue;
            }
        }

        return false;
    }

}
