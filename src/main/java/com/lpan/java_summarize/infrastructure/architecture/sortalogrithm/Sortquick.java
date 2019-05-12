package com.lpan.java_summarize.infrastructure.architecture.sortalogrithm;

/**
 * @author shipan
 * @Description: TODO 快速排序
 *                    通过一趟排序将待排记录分割为独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 *                    则可分别对这两部分记录继续进行排序，以达到整个序列有序
 *                    描述：1、从数组中选择一个基准数num(选择好的话 会提高效率)
 *                         2、分区  将大于num的数放到右边，小于num的放到左边
 *                         3、然后对分区后的区间进行上面两部操作，直到各区间只剩一个数为止
 * @ClassName: com.infrastructure.architecture.sortalogrithm
 * @date 2019/3/27 17:20
 */
public class Sortquick {

    public static void main(String[] args) {
        int [] ints = {23,4,12,6,36,4,21,8,9,21,0};
        int[] quicksort = quicksort(ints);
    }

    public static int[] quicksort(int [] ints){


        return null;
    }

}
