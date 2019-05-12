package com.lpan.java_summarize.infrastructure.architecture.algoritym.algor01;

import java.util.*;

/**
 * @author shipan
 * @Description: TODO  两数之和  给定一个目标数 在数组中找出两个数之和等于这个目标数并返回他们的下标
 *                     假设 每种输入只能又一个答案  不能重复使用数组中的值
 * @ClassName: com.infrastructure.architecture.algoritym.algor01
 * @date 2019/4/3 19:02
 */
public class TwoTotal {

    public static void main(String[] args) {
        int [] ints = {2,8,6,12,41,32,21,19,25,33};
        int target = 20;
        int[] twosum = twosum(ints, target);
        int[] getindex = getindex(ints, target);
        System.out.println(getindex);
    }

    /***
     * @Description TODO  常规的方法 使用冒泡算法  拿一个数与其他数进行比较 然后获得最后的结果
     *                    这种方法 复杂度比较高
     * @date 2019/4/4
     * @param ints 数组, target 目标值
     * @return int[]
     * @author shipan
     */
    public static int[] getindex(int[] ints,int target){
        int difference;
        int length = ints.length;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                difference = target-ints[i];
                if (ints[j] == difference && j!=i){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /***
     * @Description TODO  把数值作为key ，下标作为value
     *                    遍历数组，判断map中是否有(target-当前值) 有的话就返回  没有的话  就将这个放入到map中
     *                    由此可以在循环数组的时候 需要双层for循环的 可以考虑是否可以用map替代
     * @date 2019/4/4
     * @param ints 数组, target 目标值
     * @return int[]
     * @author shipan
     */
    public static int[] twosum(int[] ints,int target) {
        int difference;
        int length = ints.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<length;i++) {
            difference = target - ints[i];
            if (map.containsKey(difference)) {
                return new int[] {map.get(difference),i};
            }
            map.put(ints[i],i);
        }
        return new int[]{};
    }



}
