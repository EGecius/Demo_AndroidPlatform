package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

import com.egecius.demo_androidplatform.R;

public class MyFragmentActivity extends FragmentActivity {

    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        findViews();
    }

    private void findViews() {
        fragmentContainer = findViewById(R.id.container);
    }
}
