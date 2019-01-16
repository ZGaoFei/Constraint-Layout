package com.example.zhaogaofei.constraintlayouttest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.constraintlayouttest.R;

public class ConstraintLayoutAnimator2Activity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;

    private ConstraintSet oneSet;
    private ConstraintSet twoSet;
    private boolean isChanged = false;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ConstraintLayoutAnimator2Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_animator2);

        initView();
        initData();
    }

    private void initView() {
        constraintLayout = findViewById(R.id.constraint_layout_animator);

        Button button = findViewById(R.id.bt_start_change_layout);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (isChanged) {
                    reset();
                } else {
                    changeLayout();
                }
                isChanged = !isChanged;
            }
        });
    }

    private void initData() {
        oneSet = new ConstraintSet();
        oneSet.clone(constraintLayout);

        twoSet = new ConstraintSet();
        twoSet.clone(this, R.layout.constraint_layout_animator_change);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeLayout() {
        TransitionManager.beginDelayedTransition(constraintLayout);
        twoSet.applyTo(constraintLayout);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void reset() {
        TransitionManager.beginDelayedTransition(constraintLayout);
        oneSet.applyTo(constraintLayout);
    }
}
