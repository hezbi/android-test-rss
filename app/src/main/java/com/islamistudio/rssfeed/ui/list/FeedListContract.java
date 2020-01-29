package com.islamistudio.rssfeed.ui.list;

import com.islamistudio.rssfeed.data.source.remote.entity.Item;
import com.islamistudio.rssfeed.data.source.remote.response.RssResponse;
import com.islamistudio.rssfeed.ui.base.BasePresenter;
import com.islamistudio.rssfeed.ui.base.BaseView;

import java.util.List;

public interface FeedListContract {

    interface FeedListView extends BaseView {

        void onFeedListLoaded(List<Item> itemList);

        void onErrorFeedListLoaded(String message);

        void onSuccessFeedListLoaded();

    }

    interface FeedListPresenter extends BasePresenter<FeedListView> {

        void onFeedListResponse(RssResponse response);

        void getFeedList(String ext);

    }

}
