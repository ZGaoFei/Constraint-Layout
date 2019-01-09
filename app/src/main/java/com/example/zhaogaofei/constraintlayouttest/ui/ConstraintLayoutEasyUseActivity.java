package com.example.zhaogaofei.constraintlayouttest.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.constraintlayouttest.R;

/**
 * ConstraintLayout的简单实用
 */
public class ConstraintLayoutEasyUseActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ConstraintLayoutEasyUseActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_easy_use);
    }
}
