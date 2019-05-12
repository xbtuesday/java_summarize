package com.lpan.java_summarize.infrastructure.architecture.algoritym.algor01;

/**
 * @author shipan
 * @Description: TODO 整数反转
 * @ClassName: com.infrastructure.architecture.algoritym.algor01
 * @date 2019/3/22 10:10
 */
public class Reversal {


    public static void main(String[] args) {
        int num = 123456789;
        num = reversalone(num);
        System.out.println(num);
        int reversaltwo = reversaltwo(num);
        System.out.println(reversaltwo);
    }
    /***
     * @Description TODO 首先想到的是 最原始的方法
     *                 就是将数字转换成数组然后循环数组 将数字一个一个取出来然后重组返回
     * @date 2019/3/22
     * @param num
     * @return int
     * @author shipan
     */
    public static int reversalone(int num) {
        String value = String.valueOf(num);
        char[] split = value.toCharArray();
        char temp;
        /**循环数组的一半*/
        int length = split.length;
        boolean tag = length%2==1;
        for (int i=0;i<=length/2;i++){
            if (i == length/2){
                continue;
            }
            temp = split[i];
            split[i] = split[split.length-1-i];
            split[split.length-1-i] = temp;
        }
        String s = String.valueOf(split);
        Integer integer = Integer.valueOf(s);
        return integer;
    }
    /***
     * @Description TODO 也是将都转成数组 然后循环数组
     *              循环的时候 新建一个数组从原数组从后面往前面取添加到新数组中即可
     * @date 2019/3/22
     * @param num
     * @return int
     * @author shipan
     */
    public static int reversaltwo(int num){
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        char [] nchar = new char[chars.length];
        for (int i=0;i<chars.length;i++){
            nchar[i] = chars[chars.length-i-1];
        }
        String s1 = String.valueOf(nchar);
        Integer integer = Integer.valueOf(s1);
        return integer;
    }

    /***
     * @Description TODO 此方法用于将int类型整数反转
     *                  是通过取余  取到末尾数然后添加到新的字符串中 最后转为Integer即可
     *                  此方法是这三个方法中最简单的
     * @date 2019/3/22
     * @param num
     * @return int
     * @author shipan
     */
    public static int reversalthree(int num){
        return 0;
    }


}
