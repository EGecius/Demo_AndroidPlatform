package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.egecius.demo_androidplatform.R;

public class MyFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        addFragment1();
    }

    private void addFragment1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment1())
                .addToBackStack(null)
                .commit();
    }

    void showFragment2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment3())
                .addToBackStack(null)
                .commit();
    }
}
