package com.lance.dotaalarmclock.di.modules;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Corwin on 26.11.2017.
 */

@Module
public class AppModule {
    Context mContext;
    Resources mResources;

    public AppModule(Context context) {
        mContext = context;
        mResources = context.getResources();
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }
}
