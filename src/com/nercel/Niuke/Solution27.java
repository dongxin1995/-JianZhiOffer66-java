package com.nercel.Niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * https://blog.csdn.net/Felix_ar/article/details/84038226
 */
public class Solution27 {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return res;
        }
        if (str != null && str.length() > 0) {
            process(str.toCharArray(), 0, res);
            //最后的排序，保证字典序
            Collections.sort(res);
        }
        return res;
    }

    private void process(char[] str, int i, ArrayList<String> list) {
        if (i == str.length - 1) {
            String val = String.valueOf(str);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);
                process(str, i + 1, list);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
