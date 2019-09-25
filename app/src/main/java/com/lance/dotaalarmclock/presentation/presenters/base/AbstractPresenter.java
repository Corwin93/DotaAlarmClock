package com.lance.dotaalarmclock.presentation.presenters.base;

import com.lance.dotaalarmclock.domain.executor.Executor;
import com.lance.dotaalarmclock.domain.executor.MainThread;

/**
 * Created by Corwin on 18.12.2017.
 */

public abstract class AbstractPresenter {
    protected Executor   mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
