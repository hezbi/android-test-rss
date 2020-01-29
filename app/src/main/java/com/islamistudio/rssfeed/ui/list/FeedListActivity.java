package com.islamistudio.rssfeed.ui.list;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.islamistudio.rssfeed.R;
import com.islamistudio.rssfeed.data.source.remote.entity.Item;
import com.islamistudio.rssfeed.ui.base.BaseActivity;
import com.islamistudio.rssfeed.ui.base.RssFeedPresenter;
import com.islamistudio.rssfeed.utils.ProgressView;

import java.util.List;

public class FeedListActivity extends BaseActivity implements FeedListContract.FeedListView {

    private FeedListPresenter presenter;
    private ProgressView progressView;
    private RecyclerView rvItem;

    public static final String EXTRA_FEED = "extra_feed";

    public static void open(Activity activity, String url) {
        Intent intent = new Intent(activity, FeedListActivity.class);
        intent.putExtra(EXTRA_FEED, url);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_feed_list;
    }

    @Override
    protected void initView() {

        initToolbar();

        presenter = (FeedListPresenter) createPresenter();
        presenter.getFeedList();
    }

    @Override
    protected void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }

    @Override
    protected void onClickListener() {

    }

    @Override
    protected RssFeedPresenter createPresenter() {
        return new FeedListPresenter(this);
    }

    @Override
    public void onFeedListLoaded(List<Item> itemList) {
        if (itemList.size() > 0) {
            onShowItemList(itemList);
        }
    }

    @Override
    public void onErrorFeedListLoaded() {

    }

    private void onShowItemList(List<Item> itemList) {
        RecyclerView rvItem = findViewById(R.id.rv_feed);
        rvItem.setHasFixedSize(true);
        rvItem.setLayoutManager(new LinearLayoutManager(this));

        FeedListAdapter adapter = new FeedListAdapter();
        adapter.setItemList(itemList);

        rvItem.setAdapter(adapter);
    }
}
