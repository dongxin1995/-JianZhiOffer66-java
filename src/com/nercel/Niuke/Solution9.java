package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/12
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * F(n) = F（n-1）+F(n-2)+...+F(1)
 * F(n-1) = F（n-2）+F(n-3)+...+F(1)
 * <p>
 * 两个式子相减，很容易得出F(n)=2F(n-1)
 * <p>
 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        int result = 0;
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            result = 2 * JumpFloorII(target - 1);
        }
        return result;
    }
}
