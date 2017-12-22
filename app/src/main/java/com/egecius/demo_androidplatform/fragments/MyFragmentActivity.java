package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.egecius.demo_androidplatform.R;

public class MyFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        addFragment1();
    }

    private void addFragment1() {
        replaceFragment(new Fragment1(), false);
    }

    void showFragment2() {
        replaceFragment(new Fragment2(), false);
    }

    private void replaceFragment(Fragment fragment, boolean useBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment);

        if (useBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    void showFragment3() {
        replaceFragment(new Fragment3(), false);
    }
}
