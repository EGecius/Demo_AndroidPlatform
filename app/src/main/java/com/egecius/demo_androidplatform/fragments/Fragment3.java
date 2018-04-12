package com.egecius.demo_androidplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egecius.demo_androidplatform.R;

public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        view.findViewById(R.id.pop_fragment_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popTransactionFragment2();
            }
        });
        return view;
    }

    private void popTransactionFragment2() {
        ((MyFragmentActivity) getActivity()).popTransactionFragment2();
    }
}
