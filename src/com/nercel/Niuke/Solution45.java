package com.nercel.Niuke;

import java.util.Arrays;

/**
 * @author dongxin
 * @create 2019/8/15
 * <p>
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * <p>
 * <p>
 * 因为大小王可以当做任意数字，所以需要统计数组中0的个数，表示有多少张大小王。还需要计算两个相邻数字之间的差的绝对值，
 * 因为，如果两个数之间的差太大的话，即使有很多张大小王也无济于事。有了这两个结果之后，就可以对牌进行判断了，
 * 不过在此之前需要对牌进行一个排序，这样统计起来更方便。还有一种情况是，如果牌中出现了对子，那么肯定不可能是顺子
 * <p>
 * <p>
 * https://blog.csdn.net/u011116672/article/details/50296241
 */
public class Solution45 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        //对数组进行排序
        Arrays.sort(numbers);
        //统计大小王的张数
        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        int low = numberOfZero;
        int high = low + 1;
        while (high < numbers.length) {
            //如果出现了对子则不可能是顺子
            if (numbers[low] == numbers[high]) {
                return false;
            }
            //计算空缺数
            numberOfGap += numbers[high] - numbers[low] - 1;
            low = high;
            high++;
        }
        return numberOfGap <= numberOfZero ? true : false;
    }
}
