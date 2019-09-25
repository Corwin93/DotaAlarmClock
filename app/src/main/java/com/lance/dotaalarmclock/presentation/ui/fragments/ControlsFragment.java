package com.lance.dotaalarmclock.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.presentation.ui.activities.PuzzleActivity;

/**
 * Created by Andrey Grigoryev on 06.01.2018.
 */

public class ControlsFragment extends Fragment {
    public static final String TAG = "ControlsFragment";
    public static final String EXTRA_IS_SOLVED = "isSolved";

    private boolean isSolved;
    private Button btnStopAlarm;
    private ViewGroup stopButtonLock;
    private View thisView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setRetainInstance(true);
        if (savedInstanceState != null) {
            isSolved = savedInstanceState.getBoolean(EXTRA_IS_SOLVED, false);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controls, container, false);
        thisView = view;
        linking(thisView);
        if (isSolved) {
            onSolved();
        }
        return view;
    }

    public static ControlsFragment newInstance() {
        ControlsFragment fragment = new ControlsFragment();
        return fragment;
    }

    public void onSolved() {
        ConstraintLayout baseLayout = (ConstraintLayout) thisView.findViewById(R.id.controlsFragment);
        disableEnableControls(true, baseLayout);
        stopButtonLock.setVisibility(View.GONE);
        isSolved = true;
    }

    private void disableEnableControls(boolean enable, ViewGroup vg){
        for (int i = 0; i < vg.getChildCount(); i++){
            View child = vg.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup){
                disableEnableControls(enable, (ViewGroup)child);
            }
        }
    }

    private void linking(View view) {
        btnStopAlarm = view.findViewById(R.id.btnCancelAlarm);
        btnStopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((getActivity()) != null) {
                    ((PuzzleActivity)getActivity()).stopAlarmPressed();
                }
            }
        });
        stopButtonLock = view.findViewById(R.id.buttonLock);
    }
}
