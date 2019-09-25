package com.lance.dotaalarmclock.domain.executor;

/**
 * Created by Corwin on 12.12.2017.
 */

public interface MainThread {
    void post(final Runnable runnable);
}
