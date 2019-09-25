package com.lance.dotaalarmclock.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.presentation.presenters.PuzzlePresenter;
import com.lance.dotaalarmclock.presentation.presenters.impl.PuzzlePresenterImpl;
import com.lance.dotaalarmclock.presentation.presenters.persistence.PresenterCache;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.impl.PuzzlePresenterFactory;
import com.lance.dotaalarmclock.presentation.ui.fragments.ControlsFragment;
import com.lance.dotaalarmclock.presentation.ui.fragments.PuzzleFragment;
import com.lance.dotaalarmclock.presentation.ui.views.ItemBoxSet;

/**
 * Created by Corwin on 23.10.2017.
 */

public class PuzzleActivity extends AppCompatActivity implements PuzzlePresenter.PuzzleView {
    public static final String TAG = "PuzzleActivity";

    private PuzzleFragment mPuzzleFragment;
    private ControlsFragment mControlsFragment;
    private AlertDialog mDialog;
    private PuzzlePresenter mPresenter;
    private PuzzlePresenterFactory mPuzzlePresenterFactory = new PuzzlePresenterFactory();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
        mPresenter = PresenterCache.getInstance().getPresenter(PuzzlePresenterImpl.class.getName(),
                mPuzzlePresenterFactory);
        @IdRes int puzzleContainerId = R.id.puzzleContainer;
        mPuzzleFragment = PuzzleFragment.newInstance();
        addFragment(puzzleContainerId, mPuzzleFragment);
        @IdRes int controlsContainerId = R.id.controlsContainer;
        mControlsFragment = ControlsFragment.newInstance();
        addFragment(controlsContainerId, mControlsFragment);
    }

    public void addFragment(@IdRes int containerRes, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();
        bt.add(containerRes, fragment);
        bt.commit();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress()");
        mDialog = new AlertDialog.Builder(this).create();
        mDialog.setTitle("Loading...");
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "hideProgress()");
        mDialog.dismiss();
    }

    @Override
    public void onSolved() {
        Log.d(TAG, "onSolved()");
        mPuzzleFragment.onSolved();
        mControlsFragment.onSolved();
    }

    @Override
    public void setItemBoxSets(ItemBoxSet taskBoxSet, ItemBoxSet solutionBoxSet, ItemBoxSet variantBoxSet) {
        Log.d(TAG, "setItemBoxSets(ItemBoxSet taskBoxSet, ItemBoxSet solutionBoxSet, ItemBoxSet variantBoxSet)");
        mPuzzleFragment.setItemBoxSets(taskBoxSet, solutionBoxSet, variantBoxSet);
    }

    @Override
    public void setSolved(boolean isSolved) {
        Log.d(TAG, "setSolved(boolean isSolved)");
        if (isSolved) {
            mControlsFragment.onSolved();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
        mPresenter.bindView(this);
        mPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
        mPresenter.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
        mPresenter.stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        mPresenter.destroy();
    }

    @Override
    public void stopAlarmPressed() {
        Log.d(TAG, "stopAlarmPressed()");
        mPresenter.stopAlarm();
        PresenterCache.getInstance().removePresenter(mPresenter.getClass().getName());
        mPresenter.unbindView();
        finish();
    }
}
