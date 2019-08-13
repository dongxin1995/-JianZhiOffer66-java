package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/8
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 假设，一级台阶，有f(1)种方法，二级有f(2)种，以此类推，n级有f(n)种方法。

可以看出，f(1)=1;f(2)=2。

那么，假设n级台阶，那么第一步就有两种情况，跳一步，跟跳两步。

情况一：跳一步，那么接下去的就是f(n-1)；

情况二：跳两步，那么接下去的就是f(n-2)。

所以总数是f(n)=f(n-1)+f(n-2)。
 */
public class Solution8 {
    public int JumpFloor(int target) {

        if(target==1){
            return 1;

        }
        if(target==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);

    }
}
