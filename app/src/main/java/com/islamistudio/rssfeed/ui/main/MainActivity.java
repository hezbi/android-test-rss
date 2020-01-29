package com.islamistudio.rssfeed.ui.main;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import com.islamistudio.rssfeed.R;
import com.islamistudio.rssfeed.ui.base.BaseActivity;
import com.islamistudio.rssfeed.ui.base.RssFeedPresenter;
import com.islamistudio.rssfeed.ui.list.FeedListActivity;
import com.islamistudio.rssfeed.utils.DialogView;

public class MainActivity extends BaseActivity {

    private EditText edtUrl;
    private Button btnSubmit;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        initToolbar();

        edtUrl = findViewById(R.id.edt_url);
        btnSubmit = findViewById(R.id.btn_submit);

        onClickListener();
    }

    @Override
    protected void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }
    }

    @Override
    protected void onClickListener() {
        btnSubmit.setOnClickListener(view -> {
            String url = edtUrl.getText().toString();
            submitUrl(url);
        });
    }

    @Override
    protected RssFeedPresenter createPresenter() {
        return null;
    }

    private void submitUrl(String url) {
        if (url.isEmpty()) {
            DialogView.show(this, R.string.dialog_title_warning, R.string.dialog_message_empty);
        } else {
            FeedListActivity.open(MainActivity.this, url);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        edtUrl.setText("");
    }
}
