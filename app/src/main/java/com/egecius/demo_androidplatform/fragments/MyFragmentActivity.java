package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.egecius.demo_androidplatform.R;

public class MyFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        addBackStackListener();
        addFragment1();
    }

    private void addBackStackListener() {
        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        Log.i("Eg:MyFragmentActivity:27", "onBackStackChanged ");
                    }
                });
    }

    private void addFragment1() {
        Log.v("Eg:MyFragmentActivity:35", "addFragment1");
        replaceFragment(new Fragment1(), true);
    }

    void showFragment2() {
        Log.v("Eg:MyFragmentActivity:40", "showFragment2");
        replaceFragment(new Fragment2(), false);
    }

    void showFragment3() {
        Log.v("Eg:MyFragmentActivity:45", "showFragment3");
        replaceFragment(new Fragment3(), false);
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
}
