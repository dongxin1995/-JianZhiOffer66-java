package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/12
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 */
public class Solution12 {

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {

            if (base == 0) {
                return 0;
            }

            base = 1 / base;
            exponent = 0 - exponent;
        }

        double total = base;

        for (int i = 0; i < exponent - 1; i++) {
            total = total * base;
        }

        return total;

    }
}
