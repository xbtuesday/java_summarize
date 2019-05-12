package com.lpan.java_summarize.infrastructure.architecture.algoritym.algor01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shipan
 * @Description: TODO  筛选出数组中只出现一次的元素
 * @ClassName: com.infrastructure.architecture.algoritym.algor01
 * @date 2019/3/21 19:13
 */
public class NumOnlyOne {


    public static void main(String[] args) {
        String [] strs = {"1","2","r","t","2","t","r","2"};
        //String s = getnumOnlyone(strs);
        String s = getnumOnlyone1(strs);
        System.out.println(s);
    }

    /**
     * @Description TODO 普通循环两遍进行比较
     *                第一次循环每次拿一个元素 与后面的元素进行比较 如果有重复的就继续循环 如果没有重复的则返回
     *                效率不高 需要循环两遍
     * @date 2019/3/21
     * @param strs
     * @return java.lang.String
     * @author shipan
     */
    public static String getnumOnlyone(String [] strs){
        for (int i = 0;i<strs.length;i++){
            for (int j=0;j<=strs.length;j++){
                if (i==j){
                    continue;
                }
                if (strs[i] == strs[j]){
                    continue;
                }else{
                    return strs[i];
                }
            }
        }
        return null;
    }

    /**
     * @Description TODO 利用set 不能存重复的元素 set.add()  如果元素重复了 就会返回false
     *              循环一遍
     *              循环数组，拿到一个元素放入set中
     *              如果返回true 则继续循环添加，
     *              如果返回false 则说明set中已经有该元素 则移除掉 最后剩下的就是数组中只出现一次的元素
     *
     * @date 2019/3/21
     * @param strs
     * @return java.lang.String
     * @author shipan
     */
    public static String getnumOnlyone1(String[] strs){
        Set<String> set = new HashSet<>();
        for (String str:strs){
            if (!set.add(str)){
                set.remove(str);
            }
        }
        return null;
    }



}
