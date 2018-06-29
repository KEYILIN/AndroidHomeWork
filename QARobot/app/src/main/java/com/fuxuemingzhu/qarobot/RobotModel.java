package com.fuxuemingzhu.qarobot;

import android.content.Context;

import com.fuxuemingzhu.qarobot.config.API;
import com.fuxuemingzhu.qarobot.model.callback.DataCallback;
import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;


public class RobotModel extends AbsModel {
    public static RobotModel getInstance() {
        return getInstance(RobotModel.class);
    }
    public static final String API_KEY ="0abb877477c052e00496e2f9872cfa8b";
    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
    }

    public void getAnswer(String info, DataCallback callback) {
        RequestMap map = new RequestMap();
        map.put("info", info);
        map.put("dtype", "");
        map.put("loc", "");
        map.put("userid", "");
        map.put("key", API_KEY);
        RequestManager.getInstance().post(API.URL.ROBOT_URL, map, callback);
    }

}
