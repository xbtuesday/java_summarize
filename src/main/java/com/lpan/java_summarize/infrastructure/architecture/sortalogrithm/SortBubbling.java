package com.lpan.java_summarize.infrastructure.architecture.sortalogrithm;

import java.util.Arrays;

/**
 * @author shipan
 * @Description: 冒泡排序 冒泡排序并不是一种理想的排序方式复杂度相对高一点
 *                    冒泡排序思想：一组数循环取一个元素(从头开始) 然后跟临近的元素(后面的元素)进行比较
 *                    如果前面比后面的大则交换位置，如果前面的比后面的小 则保持不变
 * @ClassName: com.infrastructure.architecture.sortalogrithm
 * @date 2019/3/28 9:53
 */
public class SortBubbling {

    public static void main(String[] args) {
        int [] ints = {25,4,12,52,36,16,13,32,2,0,10};
        int[] bubble = bubblesort(ints);
        System.out.println(Arrays.toString(bubble));
    }

    private static int[] bubblesort(int[] ints) {
        int length = ints.length;
        int temp;
        for (int i = 0;i<length;i++){
            for (int j =0;j<length-1;j++){
                if (ints[j+1] < ints[j]){
                    temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
        return ints;
    }


}
