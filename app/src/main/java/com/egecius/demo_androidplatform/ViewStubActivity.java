package com.egecius.demo_androidplatform;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewStub;

public class ViewStubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);

        inflateIntoViewStub();
    }

    private void inflateIntoViewStub() {
        ViewStub viewStub = findViewById(R.id.my_view_stub);
        viewStub.setLayoutResource(R.layout.layout_to_inject);
        viewStub.inflate();
    }
}
