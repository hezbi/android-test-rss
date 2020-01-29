package com.islamistudio.rssfeed.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.islamistudio.rssfeed.R;
import com.islamistudio.rssfeed.ui.list.FeedListActivity;
import com.islamistudio.rssfeed.utils.Configure;
import com.islamistudio.rssfeed.utils.DialogView;

public class MainActivity extends AppCompatActivity {

    private EditText edtUrl;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initClickListener();
    }

    private void initView() {
        edtUrl = findViewById(R.id.edt_url);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    private void initClickListener() {
        btnSubmit.setOnClickListener(view -> {
            String url = edtUrl.getText().toString();
            submitUrl(url);
        });
    }


    private void submitUrl(String url) {
        if (url.isEmpty()) {
            DialogView.show(this, R.string.dialog_title, R.string.dialog_message_empty);
        } else if (!url.contains(Configure.BASE_URL)) {
            DialogView.show(this, R.string.dialog_title, R.string.dialog_message);
        } else {
            FeedListActivity.open(MainActivity.this, url);
        }
    }
}
