package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/15
 * <p>
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution44 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cs = str.toCharArray();
        reverse(cs, 0, cs.length - 1);
        int start = 0;
        int end = 0;
        int i = 0;
        while (i < cs.length) {
            if (i < cs.length && cs[i] == ' ') {
                i++;
                start = end = i;
            }
            while (i < cs.length && cs[i] != ' ') {
                i++;
                end++;
            }
            reverse(cs, start, end - 1);
        }
        return String.valueOf(cs);
    }

    private void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            end--;
            start++;
        }
    }
}
