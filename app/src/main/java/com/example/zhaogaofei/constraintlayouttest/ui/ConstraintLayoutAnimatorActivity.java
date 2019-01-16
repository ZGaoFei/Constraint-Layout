package com.example.zhaogaofei.constraintlayouttest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.constraintlayouttest.R;

/**
 * 关于ConstraintLayout的动画效果实现
 * 参考：
 * 译文：
 * https://github.com/xitu/gold-miner/blob/master/TODO/constraint-layout-animations-dynamic-constraints-ui-java-hell.md
 * 原文：
 * http://www.uwanttolearn.com/android/constraint-layout-animations-dynamic-constraints-ui-java-hell/
 */
public class ConstraintLayoutAnimatorActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet oneSet;
    private ConstraintSet twoSet;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ConstraintLayoutAnimatorActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_animator);

        initView();
        initData();
    }

    private void initView() {
        constraintLayout = findViewById(R.id.constraint_layout);

        Button start = findViewById(R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                // start();

                // startCenterHorizontally();

                // startRealCenterHorizontally();

                // startViewThreeCenter();

                // startViewWidth();

                // startViewAllScreen();

                // startChainOne();

                // startChainTwo();

                startChainThree();
            }
        });

        Button toDefault = findViewById(R.id.button_to_default);
        toDefault.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void initData() {
        oneSet = new ConstraintSet();
        oneSet.clone(constraintLayout);
        twoSet = new ConstraintSet();
        twoSet.clone(constraintLayout);
    }

    // 改变margin动画
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void start() {
        TransitionManager.beginDelayedTransition(constraintLayout);
        oneSet.setMargin(R.id.tv_animator_one, ConstraintSet.START, 10);
        oneSet.applyTo(constraintLayout);
    }

    /**
     * 还原状态
     *
     * twoSet中保存了constraint layout中最原始的状态
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void reset() {
        TransitionManager.beginDelayedTransition(constraintLayout);
        twoSet.applyTo(constraintLayout);
    }

    /**
     * 移动到水平居中
     * 因为本身view具有margin值，所以并不会居中显示
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startCenterHorizontally() {
        TransitionManager.beginDelayedTransition(constraintLayout);
        oneSet.centerHorizontally(R.id.tv_animator_one, R.id.constraint_layout);
        oneSet.centerHorizontally(R.id.tv_animator_two, R.id.constraint_layout);
        oneSet.centerHorizontally(R.id.tv_animator_three, R.id.constraint_layout);
        oneSet.applyTo(constraintLayout);
    }

    /**
     * 将每个布局的左右间距全部置为0，然后居中
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startRealCenterHorizontally() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        oneSet.setMargin(R.id.tv_animator_one, ConstraintSet.START, 0);
        oneSet.setMargin(R.id.tv_animator_one, ConstraintSet.END, 0);
        oneSet.setMargin(R.id.tv_animator_two, ConstraintSet.START, 0);
        oneSet.setMargin(R.id.tv_animator_two, ConstraintSet.END, 0);
        oneSet.setMargin(R.id.tv_animator_three, ConstraintSet.START, 0);
        oneSet.setMargin(R.id.tv_animator_three, ConstraintSet.END, 0);

        oneSet.centerHorizontally(R.id.tv_animator_one, R.id.constraint_layout);
        oneSet.centerHorizontally(R.id.tv_animator_two, R.id.constraint_layout);
        oneSet.centerHorizontally(R.id.tv_animator_three, R.id.constraint_layout);
        oneSet.applyTo(constraintLayout);
    }

    /**
     * 居中显示
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startViewThreeCenter() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        oneSet.setMargin(R.id.tv_animator_three, ConstraintSet.START, 0);
        oneSet.setMargin(R.id.tv_animator_three, ConstraintSet.END, 0);

        oneSet.centerHorizontally(R.id.tv_animator_three, R.id.constraint_layout);
        oneSet.centerVertically(R.id.tv_animator_three, R.id.constraint_layout);
        oneSet.applyTo(constraintLayout);
    }

    // 设置宽高变化
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startViewWidth() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        oneSet.constrainWidth(R.id.tv_animator_one, 400);
        oneSet.constrainWidth(R.id.tv_animator_two, 400);
        oneSet.constrainWidth(R.id.tv_animator_three, 400);

        // oneSet.constrainHeight(R.id.tv_animator_one, 400);
        // oneSet.constrainHeight(R.id.tv_animator_two, 400);
        // oneSet.constrainHeight(R.id.tv_animator_three, 400);

        oneSet.applyTo(constraintLayout);
    }

    /**
     * 将一个view全屏展示，其他隐藏
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startViewAllScreen() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        // 隐藏掉其他两个布局
        // oneSet.setVisibility(R.id.tv_animator_one, View.GONE);
        // oneSet.setVisibility(R.id.tv_animator_two, View.GONE);

        // 清理掉布局上所以的约束
        oneSet.clear(R.id.tv_animator_three);

        // 将布局的约束添加到父布局上，且边距为0
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.LEFT, R.id.constraint_layout, ConstraintSet.LEFT, 0);
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.RIGHT, R.id.constraint_layout, ConstraintSet.RIGHT, 0);
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.TOP, R.id.constraint_layout, ConstraintSet.TOP, 0);
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.BOTTOM, R.id.constraint_layout, ConstraintSet.BOTTOM, 0);

        oneSet.applyTo(constraintLayout);
    }

    /**
     * 用代码来实现chain的效果
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startChainOne() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        // 去除view的constraint，width和height都为0
        oneSet.clear(R.id.tv_animator_one);
        oneSet.clear(R.id.tv_animator_two);
        oneSet.clear(R.id.tv_animator_three);

        oneSet.connect(R.id.tv_animator_one, ConstraintSet.LEFT, R.id.constraint_layout, ConstraintSet.LEFT, 0);
        oneSet.connect(R.id.tv_animator_one, ConstraintSet.RIGHT, R.id.tv_animator_two, ConstraintSet.LEFT, 0);
        oneSet.connect(R.id.tv_animator_two, ConstraintSet.LEFT, R.id.tv_animator_one, ConstraintSet.RIGHT, 0);
        oneSet.connect(R.id.tv_animator_two, ConstraintSet.RIGHT, R.id.tv_animator_three, ConstraintSet.LEFT, 0);
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.LEFT, R.id.tv_animator_two, ConstraintSet.RIGHT, 0);
        oneSet.connect(R.id.tv_animator_three, ConstraintSet.RIGHT, R.id.constraint_layout, ConstraintSet.RIGHT, 0);

        // 单独给header view添加chain style，这种设置方式与使用布局的实现方式一致
        oneSet.setHorizontalChainStyle(R.id.tv_animator_one, ConstraintSet.CHAIN_PACKED);

        // 设置width和height为wrap_content
        oneSet.constrainWidth(R.id.tv_animator_one, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainWidth(R.id.tv_animator_two, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainWidth(R.id.tv_animator_three, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainHeight(R.id.tv_animator_one, 150);
        oneSet.constrainHeight(R.id.tv_animator_two, 150);
        oneSet.constrainHeight(R.id.tv_animator_three, 150);

        oneSet.applyTo(constraintLayout);
    }

    /**
     * 用代码啦实现chain的效果
     * 同上一个方式一样
     *
     * createHorizontalChain()方法内部就是讲各个布局添加constraint（约束）
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startChainTwo() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        // 去除view的constraint，width和height都为0
        oneSet.clear(R.id.tv_animator_one);
        oneSet.clear(R.id.tv_animator_two);
        oneSet.clear(R.id.tv_animator_three);

        /**
         * ConstraintSet.CHAIN_PACKED
         * ConstraintSet.CHAIN_SPREAD
         * ConstraintSet.CHAIN_SPREAD_INSIDE
         */
        oneSet.createHorizontalChain(R.id.constraint_layout, ConstraintSet.LEFT,
                R.id.constraint_layout, ConstraintSet.RIGHT,
                new int[]{R.id.tv_animator_one, R.id.tv_animator_two, R.id.tv_animator_three},
                null, ConstraintSet.CHAIN_PACKED);
        // 给header view设置bias，这种方式与使用布局实现一致，且设置bias只能是CHAIN_PACKED
        oneSet.setHorizontalBias(R.id.tv_animator_one, 0.2f);

        // 设置width和height为wrap_content
        oneSet.constrainWidth(R.id.tv_animator_one, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainWidth(R.id.tv_animator_two, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainWidth(R.id.tv_animator_three, ConstraintSet.WRAP_CONTENT);
        oneSet.constrainHeight(R.id.tv_animator_one, 150);
        oneSet.constrainHeight(R.id.tv_animator_two, 150);
        oneSet.constrainHeight(R.id.tv_animator_three, 150);

        oneSet.applyTo(constraintLayout);
    }

    /**
     * 设置如LinearLayout的权重效果
     * 前提必须是内部view的width或者height设置为MATCH_CONSTRAINT才能有效
     * 当view的width或者height设置为MATCH_CONSTRAINT时，设置的chain style将失效
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startChainThree() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        // 去除view的constraint，width和height都为0
        oneSet.clear(R.id.tv_animator_one);
        oneSet.clear(R.id.tv_animator_two);
        oneSet.clear(R.id.tv_animator_three);

        // 设置权重效果
        oneSet.createHorizontalChain(R.id.constraint_layout, ConstraintSet.LEFT,
                R.id.constraint_layout, ConstraintSet.RIGHT,
                new int[]{R.id.tv_animator_one, R.id.tv_animator_two, R.id.tv_animator_three},
                new float[]{1f, 2f, 3f},
                ConstraintSet.CHAIN_PACKED);

        // 设置width和height为wrap_content
        oneSet.constrainWidth(R.id.tv_animator_one, ConstraintSet.MATCH_CONSTRAINT);
        oneSet.constrainWidth(R.id.tv_animator_two, ConstraintSet.MATCH_CONSTRAINT);
        oneSet.constrainWidth(R.id.tv_animator_three, ConstraintSet.MATCH_CONSTRAINT);
        oneSet.constrainHeight(R.id.tv_animator_one, 150);
        oneSet.constrainHeight(R.id.tv_animator_two, 150);
        oneSet.constrainHeight(R.id.tv_animator_three, 150);

        oneSet.applyTo(constraintLayout);
    }

}
