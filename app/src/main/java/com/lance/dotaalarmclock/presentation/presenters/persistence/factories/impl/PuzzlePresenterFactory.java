package com.lance.dotaalarmclock.presentation.presenters.persistence.factories.impl;

import android.support.annotation.NonNull;

import com.lance.dotaalarmclock.domain.executor.impl.ThreadExecutor;
import com.lance.dotaalarmclock.presentation.presenters.PuzzlePresenter;
import com.lance.dotaalarmclock.presentation.presenters.impl.PuzzlePresenterImpl;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.PresenterFactory;
import com.lance.dotaalarmclock.threading.MainThreadImpl;

/**
 * Created by Corwin on 21.01.2018.
 */

public class PuzzlePresenterFactory implements PresenterFactory<PuzzlePresenter> {
    @NonNull
    @Override
    public PuzzlePresenter createPresenter() {
        return new PuzzlePresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance());
    }
}
