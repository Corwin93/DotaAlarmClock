package com.lance.dotaalarmclock.domain.interactors.impl;

import android.util.Log;

import com.lance.dotaalarmclock.App;
import com.lance.dotaalarmclock.domain.executor.Executor;
import com.lance.dotaalarmclock.domain.executor.MainThread;
import com.lance.dotaalarmclock.domain.interactors.PuzzleInteractor;
import com.lance.dotaalarmclock.domain.interactors.base.AbstractInteractor;
import com.lance.dotaalarmclock.domain.model.entity.Artifact;
import com.lance.dotaalarmclock.domain.model.entity.Item;
import com.lance.dotaalarmclock.domain.repository.utils.ArtifactRepositoryUtils;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Corwin on 18.12.2017.
 */

public class PuzzleInteractorImpl extends AbstractInteractor implements PuzzleInteractor {
    public static final String TAG = "PuzzleInteractorImpl";
    private final int mNumberOfVariantItems = 6;


    private Callback mPresenter;
    @SuppressWarnings("WeakerAccess")
    @Inject
    public ArtifactRepositoryUtils mArtifactRepositoryUtils;
    private Artifact mTaskArtifact;
    private List<Item> mVariantItems;
    private List<Item> mSolutionItems;

    public PuzzleInteractorImpl(Executor threadExecutor, MainThread mainThread, Callback mPresenter) {
        super(threadExecutor, mainThread);
        this.mPresenter = mPresenter;
        App.getComponent().inject(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        Log.d(TAG, "run()");
        mTaskArtifact = mArtifactRepositoryUtils.getRandomArtifact();
        mSolutionItems = mTaskArtifact.getCompositeItemList();
        int numberOfRandomItems = mNumberOfVariantItems - mSolutionItems.size();
        mVariantItems = mArtifactRepositoryUtils.getRandomItemList(numberOfRandomItems);
        mVariantItems.addAll(mSolutionItems);
        Collections.sort(mVariantItems);
        Log.d(TAG, "Collections.sort(mVariantItems)");
        postItemLists();
    }

    private void postItemLists() {
        Log.d(TAG, "postItemLists()");
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mPresenter.onListsReceived(mTaskArtifact, mVariantItems, mSolutionItems);
            }
        });
    }
}
