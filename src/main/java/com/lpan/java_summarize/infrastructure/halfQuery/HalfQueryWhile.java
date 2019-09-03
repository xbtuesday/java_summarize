package com.lpan.java_summarize.infrastructure.halfQuery;

/**
 * ClassName: HalfQueryWhile
 * Description: TODO  二分查找  每次查找去数组中的数进行比较
 *                                  如果目标大于中位数的值 则截取中位数右侧的数组再进行二分查找
 *                                  如果目标小于中位数的值 则截取中位数左侧的数组进行二分查找
 *                                  直到找到相对应的中位数才终止查找算法
 *                                  每经过一次  范围缩小一般
 * Author: lpan
 * Date 01/09/19 上午10:52
 * Version: 1.0
 */
public class HalfQueryWhile {


    /***
     * Description  使用while循环 进行二分查找
     * @author shipan
     * @date 01/09/19
     * @date 上午11:13
     * @param  * @param array
     * @param value
     * @return int
     */
    public static int halfQuery(int array[],int value){
        /**1、获取数组长度
         * 2、定义一个值 用来返回
         * 3、开始循环
         *      1、找出中间的数
         *      2、如果目标小于数组中间值  重新查找的数组end为 middle-1；
         *      3、如果目标大于数组中间值  重新查找的数组start为 middle+1；
         *      4、如果都大于也不小于  则就是middle
         * */
        int start = 0;
        int end = array.length;
        int middle;
        while(end >= start){
            middle = (end-start)/2+start;
            /**如果目标值小于数组中间的值*/
            if (array[middle] > value){
                end = middle-1;
            }
            /**如果目标值大于数组中间值*/
            else if (array[middle] < value){
                start = middle+1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * Description 递归实现二分查找
     * @author shipan
     * @date 01/09/19
     * @date 下午12:05
     * @param  * @param null
     * @return
     */
    public static int halfQueryRecursion(int array[],int start,int end,int value){
       int middle = (end-start)/2+start;
        if (array[middle] == value){
            return middle;
        }
       if (start >= end){
           return -1;
       } else if (array[middle] > value){
           end = middle - 1;
           return halfQueryRecursion(array,start,end,value);
       }
       else {
           start = middle + 1;
           return halfQueryRecursion(array,start,end,value);
       }

    }


    public static void main(String[] args) {
        int array [] = {1,4,5,6,7,8,9,11,45,66,76,87,88,92,93,95,96,97,100};
        int value = 66;
        int i = halfQuery(array, value);
        int i1 = halfQueryRecursion(array, 0, array.length, value);
        System.out.println("目标值所在数组的索引为："+i);
        System.out.println("目标值所在数组索引为："+ i1);
    }


}
