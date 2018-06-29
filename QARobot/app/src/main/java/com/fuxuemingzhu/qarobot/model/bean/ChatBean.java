package com.fuxuemingzhu.qarobot.model.bean;

import com.alibaba.fastjson.JSON;


public class ChatBean {
    private String sourse;
    private String time;
    private String content;

    public ChatBean() {
    }

    public ChatBean(String content, String sourse, String time) {
        this.content = content;
        this.sourse = sourse;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
