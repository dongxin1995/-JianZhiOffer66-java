package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dongxin
 * @create 2019/8/13
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 简单解释下什么是字典序，简单理解就是像英文字典那样排序，
设想一本英语字典里的单词，何者在前何者在后？
显然的做法是先按照第一个字母、以 a、b、c……z 的顺序排列；如果第一个字母一样，那么比较第二个、第三个乃至后面的字母。如果比到最后两个单词不一样长（比如，sigh 和 sight），那么把短者排在前。

分析：基于回溯法思想
---------------------
版权声明：本文为CSDN博主「Felix_ar」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Felix_ar/article/details/84038226

 */
public class Solution27 {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<String>();
        if (str==null||str.length()==0){
            return res;
        }
        if (str!=null&&str.length()>0){
            process(str.toCharArray(),0,res);
            //最后的排序，保证字典序
            Collections.sort(res);
        }
        return res;
    }

    private void process(char[] str, int i, ArrayList<String> list) {
        if (i==str.length-1){
            String val = String.valueOf(str);
            if (!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j=i;j<str.length;j++){
                swap(str,i,j);
                process(str,i+1,list);
                swap(str,i,j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i]=str[j];
        str[j]=temp;
    }
}
