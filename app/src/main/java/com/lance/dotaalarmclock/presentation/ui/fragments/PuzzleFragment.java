package com.lance.dotaalarmclock.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.presentation.ui.views.ItemBoxSet;

/**
 * Created by Corwin on 27.11.2017.
 */

public class PuzzleFragment extends Fragment {
    public static final String TAG = "PuzzleFragment";
    private View thisView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_puzzle, container, false);
        thisView = view;
        return view;
    }

    public static PuzzleFragment newInstance() {
        PuzzleFragment fragment = new PuzzleFragment();
        return fragment;
    }

    public void onSolved() {
        ConstraintLayout baseLayout = thisView.findViewById(R.id.puzzleFragment);
        disableEnableControls(false, baseLayout);
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

    public void setItemBoxSets(ItemBoxSet taskBoxSet, ItemBoxSet solutionBoxSet, ItemBoxSet variantBoxSet) {
        Log.d(TAG, "setItemBoxSets()");
        setTaskItemBox(taskBoxSet);
        setSolutionItemBoxSet(solutionBoxSet);
        setVariantItemBoxSet(variantBoxSet);
    }

    public void setTaskItemBox(final ItemBoxSet taskItemBox) {
        ViewGroup parent = (ViewGroup)taskItemBox.getParent();
        if (parent != null) {
            parent.removeView(taskItemBox);
        }
        getTaskContainer().addView(taskItemBox);
    }

    public void setSolutionItemBoxSet(ItemBoxSet solutionItemBoxSet) {
        ViewGroup parent = (ViewGroup)solutionItemBoxSet.getParent();
        if (parent != null) {
            parent.removeView(solutionItemBoxSet);
        }
        getSolutionContainer().addView(solutionItemBoxSet);
    }

    public void setVariantItemBoxSet(ItemBoxSet variantItemBoxSet) {
        ViewGroup parent = (ViewGroup)variantItemBoxSet.getParent();
        if (parent != null) {
            parent.removeView(variantItemBoxSet);
        }
        getVariantContainer().addView(variantItemBoxSet);
    }

    public LinearLayout getTaskContainer() {
        return thisView.findViewById(R.id.taskContainer);
    }

    public LinearLayout getSolutionContainer() {
        return thisView.findViewById(R.id.solutionContainer);
    }

    public LinearLayout getVariantContainer() {
        return thisView.findViewById(R.id.variantContainer);
    }
}
