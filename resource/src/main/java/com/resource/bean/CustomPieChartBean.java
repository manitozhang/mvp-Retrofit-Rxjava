package com.resource.bean;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/29
 *
 * 饼状图颜色,值,bean类
 */

public class CustomPieChartBean {
    public float percent;//值,占比
    public String content;//名字,
    public int color;//颜色

    public CustomPieChartBean(float percent, int color) {
        this.percent = percent;
        this.color = color;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public CustomPieChartBean() {
        super();
    }

    public CustomPieChartBean(float percent, String content, int color) {
        this.percent = percent;
        this.content = content;
        this.color = color;
    }
}
