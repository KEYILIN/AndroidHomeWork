package com.fuxuemingzhu.qarobot.model.callback;

import com.alibaba.fastjson.JSON;
import com.fuxuemingzhu.qarobot.config.API;
import com.fuxuemingzhu.qarobot.model.bean.Answer;
import com.fuxuemingzhu.qarobot.utils.Logcat;
import com.jude.utils.JUtils;


public abstract class DataCallback extends LinkCallback {

    @Override
    public void onRequest() {
        super.onRequest();
    }

    @Override
    public void onSuccess(String response) {

        com.alibaba.fastjson.JSONObject jsonObject;
        int status = 0;
        com.alibaba.fastjson.JSONObject result;
        Answer answer;
        try {
            jsonObject = JSON.parseObject(response);
            status = jsonObject.getIntValue(API.KEY.STATUS);

            if (status == API.CODE.SUCCEED) {
                result = jsonObject.getJSONObject(API.KEY.INFO);
                JUtils.Log("result", result.toJSONString());
                JUtils.Log("success", "init");
                answer = JSON.parseObject(result.toJSONString(), Answer.class);
                success(answer);
            } else if (status == 211200) {
                System.out.println("进入DataCallback 网络错误");
                error("网络错误");
            } else {
                System.out.println("进入DataCallback 不能理解");
                answer = new Answer(status, "robot不能理解你在说什么..");
                success(answer);
            }
        } catch (Exception e) {
            JUtils.Log(e.getLocalizedMessage());
            error("数据解析错误");
            return;
        }
        result("jsonObject", jsonObject.toJSONString());
        super.onSuccess(response);
    }

    @Override
    public void onError(String s) {
        result("error", "网络错误");
        error("网络错误");
        super.onError(s);
    }

    public void result(String status, String info) {
        Logcat.i("status", status);
        Logcat.i("info", info);
    }

    public abstract void success(Answer data);

    public void error(String errorInfo) {
        JUtils.Toast(errorInfo);
    }

}
