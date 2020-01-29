package com.islamistudio.rssfeed.ui.list;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.islamistudio.rssfeed.R;
import com.islamistudio.rssfeed.data.source.remote.entity.Item;
import com.islamistudio.rssfeed.ui.base.BaseActivity;
import com.islamistudio.rssfeed.ui.base.RssFeedPresenter;
import com.islamistudio.rssfeed.utils.DialogView;
import com.islamistudio.rssfeed.utils.ProgressView;

import java.util.List;

public class FeedListActivity extends BaseActivity implements FeedListContract.FeedListView {

    private FeedListPresenter presenter;
    private ProgressView progressView;
    private SwipeRefreshLayout swipeRefreshLayout;

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
        progressView = findViewById(R.id.progress_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            onLoadFeedList();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLoadFeedList();
    }

    @Override
    protected void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_FEED));
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
    public void onErrorFeedListLoaded(String message) {
        progressView.hide();
        DialogInterface.OnClickListener actionListener = (dialog, which) -> finish();
        DialogView.show(FeedListActivity.this, R.string.dialog_title_warning, message, actionListener);
    }

    @Override
    public void onSuccessFeedListLoaded() {
        progressView.hide();
    }

    private void onLoadFeedList() {
        progressView.show(R.string.progress_get_data);
        String url = getIntent().getStringExtra(EXTRA_FEED);
        presenter.getFeedList(url);
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
