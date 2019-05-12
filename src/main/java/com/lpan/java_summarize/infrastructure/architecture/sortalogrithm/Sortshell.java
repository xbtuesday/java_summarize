package com.lpan.java_summarize.infrastructure.architecture.sortalogrithm;

import java.util.Arrays;

/**
 * @author shipan
 * @Description: TODO  希尔排序
 *                     希尔排序是插入排序的优化 也称递减增量排序  是插入排序的更高效的改进版
 *                     他与插入排序的不同之处在于 他会优先比较距离较远的元素
 *                     希尔排序是把记录按下标的一定增量分组,对每组使用直接插入排序算法,随着增量逐渐减少,每组包含的关键词越来越多，当增量减至1时，整个文件恰北分成一组，算法终止。
 *
 * @ClassName: com.infrastructure.architecture.sortalogrithm
 * @date 2019/3/27 15:51
 */
public class Sortshell {

    public static void main(String[] args) {
        int [] ints = {25,4,12,52,36,16,13,32,2,0,10};
        int [] sortints = shellsort(ints);
        System.out.println(Arrays.toString(sortints));
    }

    private static int[] shellsort(int[] ints) {
        int length = ints.length;
        int temp;
        /**初始增量  将要对比的数分为 args个组*/
        int args = length/2;
        while(args > 0){
            for (int i = args;i<length;i++){
                /**取出*/
                temp = ints[i];
                int preindex = i-args;
                /**如果分组后 靠后的数大于前面的数 */
                while(preindex >= 0 && ints[preindex] > temp){
                    ints[preindex+args] = ints[preindex];
                    preindex = preindex-args;
                }
                ints[preindex+args] = temp;
            }
            args/=2;
        }
        return ints;
    }


}
