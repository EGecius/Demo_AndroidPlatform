package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egecius.demo_androidplatform.R;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        setOnClickListener(view);

        return view;
    }

    private void setOnClickListener(View view) {
        view.findViewById(R.id.to_fragment_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment2();
            }
        });
    }

    private void showFragment2() {
        ((MyFragmentActivity) getActivity()).showFragment2();
    }
}
