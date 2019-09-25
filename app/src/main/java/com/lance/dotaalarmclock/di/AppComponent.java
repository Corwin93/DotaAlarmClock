package com.lance.dotaalarmclock.di;

import com.lance.dotaalarmclock.di.modules.AppModule;
import com.lance.dotaalarmclock.di.modules.ArtifactModule;
import com.lance.dotaalarmclock.domain.interactors.impl.PuzzleInteractorImpl;
import com.lance.dotaalarmclock.presentation.presenters.impl.MainPresenterImpl;
import com.lance.dotaalarmclock.presentation.presenters.impl.PuzzlePresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Corwin on 21.11.2017.
 */

@Component(modules = {AppModule.class, ArtifactModule.class})
@Singleton
public interface AppComponent {
    void inject(PuzzleInteractorImpl puzzleInteractorImpl);
    void inject(MainPresenterImpl mainPresenterImpl);
    void inject(PuzzlePresenterImpl puzzlePresenterImpl);
}
