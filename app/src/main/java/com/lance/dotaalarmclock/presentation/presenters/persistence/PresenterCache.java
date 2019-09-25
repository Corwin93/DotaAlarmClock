package com.lance.dotaalarmclock.presentation.presenters.persistence;

import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

import com.lance.dotaalarmclock.presentation.presenters.base.Presenter;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.PresenterFactory;

/**
 * Created by Corwin on 09.01.2018.
 */

public class PresenterCache {
    private static PresenterCache instance = null;

    private SimpleArrayMap<String, Presenter> presenters;

    private PresenterCache() {}

    public static PresenterCache getInstance() {
        if (instance == null) {
            instance = new PresenterCache();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public final <T extends Presenter> T getPresenter(String marker, PresenterFactory<T> presenterFactory) {
        if (presenters == null) {
            presenters = new SimpleArrayMap<>();
        }
        T p = null;
        try {
            p = (T) presenters.get(marker);
        } catch (ClassCastException e) {
            Log.w("PresenterActivity", "Duplicate Presenter " +
                    "tag identified: " + marker + ". This could " +
                    "cause issues with state.");
        }
        if (p == null) {
            p = presenterFactory.createPresenter();
            presenters.put(marker, p);
        }
        return p;
    }

    public final void removePresenter(String marker) {
        if (presenters != null) {
            presenters.remove(marker);
        }
    }
}
