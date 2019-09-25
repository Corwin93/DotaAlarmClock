package com.lance.dotaalarmclock.presentation.presenters.persistence.factories;

import android.support.annotation.NonNull;

import com.lance.dotaalarmclock.presentation.presenters.base.Presenter;

/**
 * Created by Corwin on 09.01.2018.
 */

public interface PresenterFactory<T extends Presenter> {
    @NonNull T createPresenter();
}
