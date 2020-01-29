package com.islamistudio.rssfeed.ui.list;

import com.islamistudio.rssfeed.data.source.remote.Api;
import com.islamistudio.rssfeed.data.source.remote.entity.Item;
import com.islamistudio.rssfeed.data.source.remote.response.RssResponse;
import com.islamistudio.rssfeed.ui.base.RssFeedPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FeedListPresenter extends RssFeedPresenter<FeedListContract.FeedListView> implements FeedListContract.FeedListPresenter {

    public FeedListPresenter(FeedListContract.FeedListView view) {
        super(view);
    }

    @Override
    public void onFeedListResponse(RssResponse response) {

        List<Item> items = new ArrayList<>();

        for (Item i : response.getChannel().getItem()) {
            Item item = new Item();
            item.setTitle(i.getTitle());
            item.setDescription(i.getDescription());
            item.setGuid(i.getGuid());
            item.setLink(i.getLink());
            item.setPubDate(i.getPubDate());

            items.add(item);
        }

        view.onFeedListLoaded(items);
    }

    @Override
    public void getFeedList(String ext) {

        Retrofit retrofit = createRetrofit();
        if (retrofit != null) {
            Api api = retrofit.create(Api.class);
            Observable<RssResponse> observable = api.getSoccerXML(ext);
            observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RssResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(RssResponse rssResponse) {
                            onFeedListResponse(rssResponse);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e instanceof java.net.UnknownHostException || e instanceof java.net.ConnectException || e instanceof java.net.SocketTimeoutException) {
                                view.onErrorFeedListLoaded("Tidak ada koneksi intenet");
                            } else {
                                view.onErrorFeedListLoaded(e.getMessage());
                            }
                        }

                        @Override
                        public void onComplete() {
                            view.onSuccessFeedListLoaded();
                        }
                    });
        }

    }
}
