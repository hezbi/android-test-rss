package com.islamistudio.rssfeed.ui.list;

import android.util.Log;

import com.islamistudio.rssfeed.data.source.remote.Api;
import com.islamistudio.rssfeed.data.source.remote.entity.Item;
import com.islamistudio.rssfeed.data.source.remote.response.RssResponse;
import com.islamistudio.rssfeed.ui.base.RssFeedPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    public void getFeedList() {

        Retrofit retrofit = createRetrofit();
        if (retrofit != null) {
            Api api = retrofit.create(Api.class);
            Call<RssResponse> callXML = api.getSoccerXML();
            callXML.enqueue(new Callback<RssResponse>() {
                @Override
                public void onResponse(@NotNull Call<RssResponse> call, @NotNull Response<RssResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            onFeedListResponse(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<RssResponse> call, @NotNull Throwable t) {
                    Log.d("TAG", "onFailure: ");
                }
            });
        }

    }
}
