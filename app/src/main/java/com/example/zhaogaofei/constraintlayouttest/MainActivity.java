package com.example.zhaogaofei.constraintlayouttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutEasyUseActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initView();
    }

    private void initView() {
        findViewById(R.id.tv_easy_use).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutEasyUseActivity.start(mContext);
            }
        });
    }
}