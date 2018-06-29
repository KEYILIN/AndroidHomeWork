package com.fuxuemingzhu.qarobot.module.robot;

import android.os.Bundle;

import com.fuxuemingzhu.qarobot.RobotModel;
import com.fuxuemingzhu.qarobot.model.bean.Answer;
import com.fuxuemingzhu.qarobot.model.bean.ChatBean;
import com.fuxuemingzhu.qarobot.model.callback.DataCallback;
import com.fuxuemingzhu.qarobot.utils.DateUtil;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;


public class RobotPresenter extends BeamListFragmentPresenter<RobotFragment, ChatBean> {


    @Override
    protected void onCreate(RobotFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        initChat();
    }

    @Override
    public DataAdapter getAdapter() {
        return super.getAdapter();
    }

    private void initChat() {
        getAdapter().clear();
        ChatBean chatBean = new ChatBean("欢迎来跟我聊天，我是robot", "robot：", DateUtil.getCurrentDate3());
        updateView(chatBean);
    }

    private void updateView(ChatBean chatBean) {
        getAdapter().add(chatBean);
    }

    public void setMsg(String msg) {
        ChatBean chatBean = new ChatBean(msg, "我：", DateUtil.getCurrentDate3());
        getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
        getAdapter().add(chatBean);
        RobotModel.getInstance().getAnswer(msg, new DataCallback() {
            @Override
            public void success(Answer data) {
                ChatBean chatBean = new ChatBean(data.getText(), "robot：", DateUtil.getCurrentDate3());
                updateView(chatBean);
                getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
            }

            @Override
            public void error(String errorInfo) {
                super.error(errorInfo);
                ChatBean chatBean = new ChatBean("这我也不知道了", "robot：", DateUtil.getCurrentDate3());
                updateView(chatBean);
                getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
            }

        });
    }
}
