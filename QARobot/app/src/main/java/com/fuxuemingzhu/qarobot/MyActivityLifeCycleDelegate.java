package com.fuxuemingzhu.qarobot;

import android.app.Activity;
import android.os.Bundle;

import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.utils.JUtils;
import com.umeng.analytics.MobclickAgent;


public class MyActivityLifeCycleDelegate extends ActivityLifeCycleDelegate {
    public MyActivityLifeCycleDelegate(Activity act) {
        super(act);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JUtils.Log("onCreate" + getActivity().getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JUtils.Log("onPause");
        MobclickAgent.onPause(getActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        JUtils.Log("onResume");
        MobclickAgent.onResume(getActivity());
    }
}
