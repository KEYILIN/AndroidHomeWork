package com.fuxuemingzhu.qarobot.model.bean;

import com.alibaba.fastjson.JSON;


public class Answer {

    private int code;
    private String text;

    public Answer() {
    }

    public Answer(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
