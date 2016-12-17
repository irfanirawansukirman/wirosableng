package com.iriras.wirosableng.pages.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.iriras.wirosableng.R;
import com.iriras.wirosableng.WirosablengApp;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends WirosablengApp implements View.OnClickListener {
    @Bind(R.id.fab_main)
    FloatingActionButton mFabMain;
    @Bind(R.id.fab_popular)
    FloatingActionButton mFabPopular;
    @Bind(R.id.fab_rating)
    FloatingActionButton mFabRating;

    public Boolean isFabOpen = false;
    public Animation fab_open, fab_close, fab_forward, fab_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        mFabMain.setOnClickListener(this);
        mFabPopular.setOnClickListener(this);
        mFabRating.setOnClickListener(this);
    }

    public void fabAnime() {
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        fab_forward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        fab_backward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        if (isFabOpen) {
            mFabMain.startAnimation(fab_backward);
            mFabRating.startAnimation(fab_close);
            mFabPopular.startAnimation(fab_close);
            mFabRating.setClickable(false);
            mFabPopular.setClickable(false);
            isFabOpen = false;
        } else {
            mFabMain.startAnimation(fab_forward);
            mFabPopular.startAnimation(fab_open);
            mFabRating.startAnimation(fab_open);
            mFabPopular.setClickable(true);
            mFabRating.setClickable(true);
            isFabOpen = true;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab_main:
                fabAnime();
                break;
            case R.id.fab_popular:
                break;
            case R.id.fab_rating:
                break;
        }
    }
}
