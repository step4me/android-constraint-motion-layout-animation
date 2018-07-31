package com.step4me.constraintandmotionlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraint_layout);
        applyConstraintSet.clone(constraintLayout);
        resetConstraintSet.clone(constraintLayout);
    }

    public void onApplyClick(View view) {
        animateExpandImageView();
    }

    public void onResetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }

    private void animateExpandImageView() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        applyConstraintSet.clear(R.id.iv_thumnail);
        applyConstraintSet.clear(R.id.tv_description);

        // connect(int startID, int startSide, int endID, int endSide, int margin)
        // app:layout_constraintTop_toTopOf="parent"
        applyConstraintSet.connect(R.id.iv_thumnail, ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        applyConstraintSet.connect(R.id.iv_thumnail, ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        applyConstraintSet.connect(R.id.iv_thumnail, ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        applyConstraintSet.connect(R.id.iv_thumnail, ConstraintSet.BOTTOM,
                R.id.tv_description, ConstraintSet.TOP, 20);
        applyConstraintSet.constrainWidth(R.id.iv_thumnail, ConstraintSet.MATCH_CONSTRAINT);
        applyConstraintSet.constrainHeight(R.id.iv_thumnail, ConstraintSet.MATCH_CONSTRAINT);
        applyConstraintSet.setVerticalWeight(R.id.iv_thumnail, 4);

        applyConstraintSet.connect(R.id.tv_description, ConstraintSet.TOP,
                R.id.iv_thumnail, ConstraintSet.BOTTOM, 20);
        applyConstraintSet.connect(R.id.tv_description, ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        applyConstraintSet.connect(R.id.tv_description, ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        applyConstraintSet.connect(R.id.tv_description, ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
        applyConstraintSet.centerHorizontally(R.id.tv_description, R.id.constraint_layout);
        applyConstraintSet.constrainWidth(R.id.tv_description, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.tv_description, ConstraintSet.MATCH_CONSTRAINT);
        applyConstraintSet.setVerticalWeight(R.id.tv_description, 1);
        applyConstraintSet.applyTo(constraintLayout);
    }
}
