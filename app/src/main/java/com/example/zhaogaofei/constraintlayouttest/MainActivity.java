package com.example.zhaogaofei.constraintlayouttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutAnimator2Activity;
import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutAnimatorActivity;
import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutEasyUseActivity;
import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutFourActivity;
import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutThreeActivity;
import com.example.zhaogaofei.constraintlayouttest.ui.ConstraintLayoutTwoActivity;

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

        findViewById(R.id.tv_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutTwoActivity.start(mContext);
            }
        });

        findViewById(R.id.tv_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutThreeActivity.start(mContext);
            }
        });

        findViewById(R.id.tv_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutFourActivity.start(mContext);
            }
        });

        findViewById(R.id.tv_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutAnimatorActivity.start(mContext);
            }
        });

        findViewById(R.id.tv_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayoutAnimator2Activity.start(mContext);
            }
        });
    }
}
