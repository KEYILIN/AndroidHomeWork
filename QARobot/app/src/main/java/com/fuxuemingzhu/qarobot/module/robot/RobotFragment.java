package com.fuxuemingzhu.qarobot.module.robot;

import android.view.ViewGroup;

import com.fuxuemingzhu.qarobot.model.bean.ChatBean;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;



@RequiresPresenter(RobotPresenter.class)
public class RobotFragment extends BeamListFragment<RobotPresenter, ChatBean> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new RobotVH(viewGroup);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(false)
                .setRefreshAble(false)
                .setNoMoreAble(false)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);

    }
}
