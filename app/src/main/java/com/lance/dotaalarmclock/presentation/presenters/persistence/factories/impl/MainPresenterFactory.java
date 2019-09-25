package com.lance.dotaalarmclock.presentation.presenters.persistence.factories.impl;

import android.support.annotation.NonNull;

import com.lance.dotaalarmclock.domain.executor.impl.ThreadExecutor;
import com.lance.dotaalarmclock.presentation.presenters.MainPresenter;
import com.lance.dotaalarmclock.presentation.presenters.impl.MainPresenterImpl;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.PresenterFactory;
import com.lance.dotaalarmclock.threading.MainThreadImpl;

/**
 * Created by Corwin on 21.01.2018.
 */

public class MainPresenterFactory implements PresenterFactory<MainPresenter> {
    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance());
    }
}
