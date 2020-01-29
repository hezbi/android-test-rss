package com.islamistudio.rssfeed.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initToolbar();

    protected abstract void onClickListener();

    protected abstract RssFeedPresenter createPresenter();

    protected RssFeedPresenter basePresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        basePresenter = createPresenter();

        onAttachView();
    }

    @Override
    public void onAttachView() {
        if (basePresenter != null) {
            basePresenter.onAttach(this);
        }

        initView();
    }

    @Override
    public void onDetachView() {
        if (basePresenter != null) {
            basePresenter.onDetach();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
