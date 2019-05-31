package com.lpan.java_summarize.base.enums;

/**
 * ClassName: SeasonEnum
 * Description: TODO
 * Author: lpan
 * Date 30/05/19 下午 02:07
 * Version: 1.0
 */
public enum SeasonEnum {
    /**  枚举的定义必须要显示在最前面 */
    SPRING(1,"春天"),SUMMER(2,"夏天"),AUTUMN(3,"秋天"),WINTER(4,"冬天");
    private int order;
    private String chinese;
    /***/
    private SeasonEnum(int order,String chinese){
        this.order = order;
        this.chinese = chinese;
    }

    public String getChinese(){
        return chinese;
    }
}
