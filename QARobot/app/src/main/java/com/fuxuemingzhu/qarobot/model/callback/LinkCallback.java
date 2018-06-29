package com.fuxuemingzhu.qarobot.model.callback;

import com.jude.http.RequestListener;


public class LinkCallback implements RequestListener {

    private LinkCallback link;

    public LinkCallback add(LinkCallback other) {
        other.setLink(this);
        return other;
    }

    public void setLink(LinkCallback link) {
        this.link = link;
    }


    @Override
    public void onRequest() {
        if (link != null)
            link.onRequest();
    }

    @Override
    public void onSuccess(String response) {
        if (link != null)
            link.onSuccess(response);
    }

    @Override
    public void onError(String errorMsg) {
        if (link != null)
            link.onError(errorMsg);
    }
}
