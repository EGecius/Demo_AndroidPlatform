package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.egecius.demo_androidplatform.R;

public class MyFragmentActivity extends FragmentActivity {

    boolean useBackStack = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        addFragment1();
    }

    private void addFragment1() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new Fragment1())
//                .addToBackStack(null)
                .commit();
    }

    void showFragment2() {
        Fragment2 fragment = new Fragment2();
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment);

        if (useBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    void showFragment3() {
        Fragment3 fragment = new Fragment3();
        replaceFragment(fragment);
    }
}
