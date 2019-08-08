package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        if (str==null){
            return null;
        }

        StringBuilder res =new StringBuilder();
        for (int i= 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                res.append('%');
                res.append('2');
                res.append('0');
            }
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
