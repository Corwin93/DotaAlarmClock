package com.lance.dotaalarmclock;

import android.app.Application;

import com.lance.dotaalarmclock.di.AppComponent;
import com.lance.dotaalarmclock.di.DaggerAppComponent;
import com.lance.dotaalarmclock.di.modules.AppModule;
import com.lance.dotaalarmclock.di.modules.ArtifactModule;

/**
 * Created by Corwin on 25.11.2017.
 */

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .artifactModule(new ArtifactModule())
                .build();
    }


}
