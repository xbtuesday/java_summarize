package com.lpan.java_summarize.infrastructure.architecture.sortalogrithm;

import java.util.Arrays;

/**
 * @author shipan
 * @Description: TODO  直接插入排序
 *                     插入排序基本思想：在要排序的一组数中 假设前面(n-1)[n>=2] 个数已经是排好顺序的，
 *                     现在把第n个数插入到前面的有序数中使得这n个数也是排好顺序的，如此反复循环，直到全部排好顺序
 * @ClassName: com.infrastructure.architecture.sortalogrithm
 * @date 2019/3/27 9:37
 */
public class Sortofinsert {
    public static void main(String[] args) {
        int [] ins = {12,36,45,2,11,8,4,3,24,15,21,32};
        int [] sortins = sortofinsert(ins);
        int[] myselfinsertsort = myselfinsertsort(ins);
        System.out.println(Arrays.toString(sortins));
        System.out.println(Arrays.toString(myselfinsertsort));
    }

    public static int[] sortofinsert(int[] ints){
        /**数组长度 提高效率 不用每次都获取*/
        int length = ints.length;
        /**要插入的数*/
        int insertnum;
        /**假设第一个位置正确从后面的往前循环*/
        for (int i=1;i<length;i++){
            /**将后面的数拿到后 赋值给insertnum*/
            insertnum = ints[i];
            /**序列元素个数*/
            int j = i-1;
            /**从后往前循环  将大于insertnum的数向后移动*/
            while(j>=0 && ints[j] > insertnum){
                /**元素向后移动*/
                ints[j+1] = ints[j];
                j--;
            }
            /**找到位置，插入当前元素*/
            ints[j+1] = insertnum;
        }
        return ints;
    }

    public static int[] myselfinsertsort(int[] ints){
        int length = ints.length;
        int temp;
        for (int i=0;i<length;i++){
            /**将要比较的数 赋值给临时变量*/
            temp = ints[i];
            /**要比较的元素位置的前面一个位置  要比较的数的前面的数 都是排好序的*/
            int j = i-1;
            /**如果比较的数 比前面的数大  则将前面的数 往后移*/
            while(j>=0 && ints[j] > temp){
               ints[j+1] = ints[j];
               j--;
            }
            ints[j+1] = temp;
        }
        return  ints;

    }


}
