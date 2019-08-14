package com.nercel.Niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongxin
 * @create 2019/8/14
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 *
 */
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0||str==null){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        char[] array = str.toCharArray();
        for (int i= 0;i<array.length;i++){
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i])+1);
            }
        }

        for (int i=0;i<str.length();i++){
            if (map.get(array[i])==1){
                return i;
            }
        }
        return -1;
    }
}
