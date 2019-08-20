package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/20
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * <p>
 * 第一步：创建一个行为rows,列为cols的boolean型数组，用来标记走过的位置，初始化为false，true表示走过。
 * <p>
 * 第二步：函数sum (int i,int j)用来计算i，j两数的数位之和。
 * <p>
 * 第三步：judge函数用来递归出可以到达的格子数，judge(int threshold,int rows, int cols, boolean[][] flag,int i,int j)，返回值为Int。
 * <p>
 * 第四步：进入judge函数，判断i,j是否越界，或sum (i, j) > threshold 或 flag[i][j] == true，满足其一，说明不能走这个格子或者这个格子已经走过了，并在计数，返回0。
 * <p>
 * 第五步：不满足第四步的判断，将此格子在flag中标记为true，标记走过了。
 * <p>
 * 第六步：递归这个位置的上、下、左、右，返回递归的上、下、左、右再加1（加上自己）的和。
 * <p>
 * 第七步：在movingCount函数中调用judge函数，初始的位置即i=0，j=0,让其递归出结果直接返回。
 */
public class Solution66 {

    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] flag = new boolean[rows][cols];//标记

        return judge(threshold, rows, cols, flag, 0, 0);

    }

    private int judge(int threshold, int rows, int cols, boolean[][] flag, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || sum(i, j) > threshold || flag[i][j] == true) {
            return 0;
        }
        flag[i][j] = true;
        return 1 + judge(threshold, rows, cols, flag, i - 1, j)
                + judge(threshold, rows, cols, flag, i + 1, j)
                + judge(threshold, rows, cols, flag, i, j - 1)
                + judge(threshold, rows, cols, flag, i, j + 1);
    }

    //计算i,j的数位之和
    private int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }
}
