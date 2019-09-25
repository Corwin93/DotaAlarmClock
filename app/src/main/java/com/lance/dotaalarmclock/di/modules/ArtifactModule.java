package com.lance.dotaalarmclock.di.modules;

import com.lance.dotaalarmclock.domain.repository.ArtifactRepository;
import com.lance.dotaalarmclock.domain.repository.utils.ArtifactRepositoryUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Corwin on 25.11.2017.
 */

@Module
public class ArtifactModule {
    @Provides
    @Singleton
    public ArtifactRepository provideArtifactRepository() {
        return new ArtifactRepository();
    }

    @Provides
    @Singleton
    public ArtifactRepositoryUtils provideArtifactRepositoryUtils(ArtifactRepository artifactRepository) {
        return new ArtifactRepositoryUtils(artifactRepository);
    }
}
