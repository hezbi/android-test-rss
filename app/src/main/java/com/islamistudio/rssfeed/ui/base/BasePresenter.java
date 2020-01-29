package com.islamistudio.rssfeed.ui.base;

public interface BasePresenter<T extends BaseView> {

    void onAttach(T view);

    void onDetach();
}
