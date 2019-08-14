package com.nercel.Niuke;


/**
 * @author dongxin
 * @create 2019/8/14
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        String a = "", b = "";
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                a = numbers[j] + "" + numbers[j + 1];
                b = numbers[j + 1] + "" + numbers[j];
                if (a.compareTo(b) > 0) {
                    swap(numbers, j, j + 1);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            builder.append(numbers[i]);
        }
        return builder.toString();
    }

    public void swap(int[] numbers, int source, int target) {
        int temp = numbers[source];
        numbers[source] = numbers[target];
        numbers[target] = temp;
    }
}
