package com.lance.dotaalarmclock.presentation.presenters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lance.dotaalarmclock.presentation.presenters.base.Presenter;
import com.lance.dotaalarmclock.presentation.ui.views.ItemBoxSet;

/**
 * Created by Corwin on 18.12.2017.
 */

public interface PuzzlePresenter extends Presenter<PuzzlePresenter.PuzzleView> {
    void startAlarm();

    void stopAlarm();

    void onImageDragged(ImageView draggedImage, ImageView replacedImage,
                        LinearLayout oldBox, LinearLayout newBox);

    boolean isSolved();

    interface PuzzleView {
        Context getContext();
        void showProgress();
        void hideProgress();
        void onSolved();
        void setItemBoxSets(ItemBoxSet taskBoxSet, ItemBoxSet solutionBoxSet, ItemBoxSet variantBoxSet);
        Resources getResources();

        void setSolved(boolean isSolved);

        void stopAlarmPressed();
    }
}
