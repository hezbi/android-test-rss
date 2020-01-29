package com.islamistudio.rssfeed.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.islamistudio.rssfeed.R;

public class ProgressView extends FrameLayout {

    private TextView tvProgressView;

    public ProgressView(@NonNull Context context) {
        super(context);

        init();
    }

    public ProgressView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ProgressView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_progress, this);
        hide();

        if (isInEditMode()) return;

        tvProgressView = view.findViewById(R.id.tvProgressBar);
    }

    public void hide() {
        setVisibility(GONE);
    }

    public void show(int action) {
        tvProgressView.setText(action);
        setVisibility(VISIBLE);
    }

    public void show(String action) {
        tvProgressView.setText(action);
        setVisibility(VISIBLE);
    }
}
