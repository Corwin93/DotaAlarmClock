package com.lance.dotaalarmclock.domain.executor;

import com.lance.dotaalarmclock.domain.interactors.base.AbstractInteractor;

/**
 * Created by Corwin on 12.12.2017.
 */

public interface Executor {
    void execute(final AbstractInteractor interactor);
}
