package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/16
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:

如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {

    int[] hashTable = new int[256];
    StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch)
    {

        sb.append(ch);
        if (hashTable[ch]==0){
            hashTable[ch]=1;
        }else {
            hashTable[ch]+=1;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] str = sb.toString().toCharArray();
        for (char c:str){
            if (hashTable[c]==1){
                return c;
            }
        }
        return '#';
    }
}
