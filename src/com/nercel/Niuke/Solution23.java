package com.nercel.Niuke;

/**
 * @author dongxin
 * @create 2019/8/13
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 * <p>
 * https://blog.csdn.net/qq_41901915/article/details/90270150
 */
public class Solution23 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        //当递归过程进行到只剩下两个元素的时候还没有返回false，那么他就是ture
        if (end - start <= 1) {
            return true;
        }
        //将根节点赋值
        int endVal = sequence[end];
        int curNumber = start;

        while (curNumber < end && sequence[curNumber] < endVal) {
            curNumber++;
        }
        for (int i = curNumber; i < end; i++) {
            if (sequence[i] < endVal) {
                return false;
            }
        }
        //注意此处的参数是currentNumber-1和currentNumber不是currentNumber和currentNumber+1
        //因为在上面while循环之后，已经自增完了，不满足条件了，所以不执行了，所以在currentNumber
        //是不满足条件的，所以要回退一个
        //另外后面是end-1，因为每次都会去掉一个根节点
        return VerifySquenceOfBST(sequence, start, curNumber - 1) && VerifySquenceOfBST(sequence, curNumber, end);
    }

}
