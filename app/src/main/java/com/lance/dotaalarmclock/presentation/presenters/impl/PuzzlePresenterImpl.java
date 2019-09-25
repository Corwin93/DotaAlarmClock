package com.lance.dotaalarmclock.presentation.presenters.impl;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lance.dotaalarmclock.App;
import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.domain.executor.Executor;
import com.lance.dotaalarmclock.domain.executor.MainThread;
import com.lance.dotaalarmclock.domain.interactors.PuzzleInteractor;
import com.lance.dotaalarmclock.domain.interactors.impl.PuzzleInteractorImpl;
import com.lance.dotaalarmclock.domain.model.entity.Artifact;
import com.lance.dotaalarmclock.domain.model.entity.Item;
import com.lance.dotaalarmclock.presentation.presenters.MainPresenter;
import com.lance.dotaalarmclock.presentation.presenters.PuzzlePresenter;
import com.lance.dotaalarmclock.presentation.presenters.base.AbstractPresenter;
import com.lance.dotaalarmclock.presentation.presenters.persistence.PresenterCache;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.impl.MainPresenterFactory;
import com.lance.dotaalarmclock.presentation.ui.views.ItemBoxSet;
import com.lance.dotaalarmclock.services.AlarmService;
import com.lance.dotaalarmclock.services.PlayerReceiver;
import com.lance.dotaalarmclock.services.PlayerService;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Corwin on 18.12.2017.
 */

public class PuzzlePresenterImpl extends AbstractPresenter implements PuzzlePresenter, PuzzleInteractor.Callback {
    public static final String TAG = "PuzzlePresenterImpl";

    private PuzzleInteractor mPuzzleInteractor;
    @Inject
    public Context mAppContext;
    private PuzzleView mPuzzleView;
    private ItemBoxSet mTaskBox;
    private ItemBoxSet mSolutionBoxSet;
    private ItemBoxSet mVariantBoxSet;
    private boolean isSolved = false;
    private List<Integer> mSolutionResIdList;
    private List<Integer> mProposedSolutionResIdList;
    private Intent mPlaybackServiceIntent;

    public PuzzlePresenterImpl(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
        App.getComponent().inject(this);
        mSolutionResIdList = new LinkedList<>();
        mProposedSolutionResIdList = new LinkedList<>();
    }

    @Override
    public void bindView(PuzzleView view) {
        Log.d(TAG, "bindView(PuzzleView view)");
        mPuzzleView = view;
        mPlaybackServiceIntent = new Intent(mPuzzleView.getContext(), PlayerService.class);
    }

    @Override
    public void unbindView() {
        Log.d(TAG, "unbindView()");
        mPuzzleView = null;
    }

    @Override
    public boolean isBinded() {
        return mPuzzleView != null;

    }

    @Override
    public void resume() {
        Log.d(TAG, "resume()");
        if (mTaskBox == null ||
                mSolutionBoxSet == null ||
                mVariantBoxSet == null) {
            onLoading();
            startAlarm();
            mPuzzleInteractor = new PuzzleInteractorImpl(mExecutor, mMainThread, this);
            mPuzzleInteractor.execute();
        } else {
            mPuzzleView.setItemBoxSets(mTaskBox, mSolutionBoxSet, mVariantBoxSet);
            mPuzzleView.setSolved(isSolved);
        }
    }

    @Override
    public void pause() {
        Log.d(TAG, "pause()");
    }

    @Override
    public void stop() {
        Log.d(TAG, "stop()");
    }

    @Override
    public void destroy() {
        Log.d(TAG, "destroy()");
    }

    @Override
    public void onError(String message) {
        Log.d(TAG, "onError(String message)");
    }

    @Override
    public void startAlarm() {
        Log.d(TAG, "startAlarm()");
        Intent broadcastIntent = new Intent(PlayerReceiver.BROADCAST_PLAYER);
        mPuzzleView.getContext().sendBroadcast(broadcastIntent);
    }

    @Override
    public void stopAlarm() {
        Log.d(TAG, "stopAlarm()");
        mPuzzleView.getContext().stopService(mPlaybackServiceIntent);
        MainPresenter mainPresenter = PresenterCache.getInstance().getPresenter(MainPresenterImpl.class.getName(), new MainPresenterFactory());
        if (mainPresenter.isBinded()) {
            mainPresenter.onAlarmCancelled();
        } else {
            dismissNotification();
        }
    }

    private void dismissNotification() {
        NotificationManager manager = (NotificationManager) mAppContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.cancel(AlarmService.NOTIFICATION_ALARM_ID);
        }
    }

    @Override
    public void onLoading() {
        Log.d(TAG, "onLoading()");
        mPuzzleView.showProgress();
    }

    @Override
    public void onListsReceived(Artifact taskArtifact, List<Item> variantItems, List<Item> solutionItems) {
        Log.d(TAG, "onListsReceived(Artifact taskArtifact, List<Item> variantItems, List<Item> solutionItems)");
        List<Item> taskList = new LinkedList<>();
        taskList.add(taskArtifact);
        mTaskBox = new ItemBoxSet(mPuzzleView.getContext());
        mTaskBox.addItemBoxes(1);
        mTaskBox.addImage(taskArtifact.getImageResourceId(), false);
        mSolutionBoxSet = new ItemBoxSet(mPuzzleView.getContext());
        mSolutionBoxSet.addItemBoxes(solutionItems.size());
        extractSolutionImages(solutionItems);
        for (View view: mSolutionBoxSet.getChildViews()) {
            view.setOnDragListener(new BoxDragListener());
        }
        mVariantBoxSet = createItemBoxSetFromList(variantItems);
        mPuzzleView.setItemBoxSets(mTaskBox, mSolutionBoxSet, mVariantBoxSet);
        mPuzzleView.hideProgress();
    }

    private void extractSolutionImages(List<Item> solutionItems) {
        for (Item item: solutionItems) {
            mSolutionResIdList.add(item.getImageResourceId());
        }
    }

    private ItemBoxSet createItemBoxSetFromList(List<Item> itemList) {
        Log.d(TAG, "createItemBoxSetFromList(List<Item> itemList)");
        ItemBoxSet itemBoxSet = new ItemBoxSet(mPuzzleView.getContext());
        itemBoxSet.addItemBoxes(itemList.size());
        for (Item item: itemList) {
            itemBoxSet.addImage(item.getImageResourceId(), true);
        }
        for (View view: itemBoxSet.getChildViews()) {
            view.setOnDragListener(new BoxDragListener());
        }
        return itemBoxSet;
    }

    @Override
    public void onImageDragged(ImageView draggedImage, ImageView replacedImage,
                               LinearLayout oldBox, LinearLayout newBox) {
        if (oldBox.getParent().equals(mVariantBoxSet) && newBox.getParent().equals(mSolutionBoxSet)) {
            if (replacedImage != null) {
                mProposedSolutionResIdList.remove((Integer) replacedImage.getTag());
            }
            mProposedSolutionResIdList.add((Integer) draggedImage.getTag());
        } else if (oldBox.getParent().equals(mSolutionBoxSet) && newBox.getParent().equals(mVariantBoxSet)) {
            if (replacedImage != null) {
                mProposedSolutionResIdList.add((Integer) replacedImage.getTag());
            }
            mProposedSolutionResIdList.remove((Integer) draggedImage.getTag());
        }
        if (isSolved()) {
            isSolved = true;
            mPuzzleView.onSolved();
        }
    }

    @Override
    public boolean isSolved() {
        if (mSolutionResIdList.size() == mProposedSolutionResIdList.size()) {
            for (int resId: mProposedSolutionResIdList) {
                if (!mSolutionResIdList.contains(resId)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public class BoxDragListener implements View.OnDragListener {
        Drawable enterShape = mPuzzleView.getResources().getDrawable(R.drawable.item_box_entered);
        Drawable normalShape = mPuzzleView.getResources().getDrawable(R.drawable.item_box_background);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            View dragItem = (View) event.getLocalState();
            float initX = dragItem.getX();
            float initY = dragItem.getY();

            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackground(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackground(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    LinearLayout owner = (LinearLayout) dragItem.getParent(); //old box
                    owner.removeView(dragItem);
                    LinearLayout container = (LinearLayout) v; //new box
                    ImageView oldImage = null;
                    if (container.getChildCount() > 0) {
                        oldImage = (ImageView) container.getChildAt(0);
                        container.removeView(oldImage);
                        owner.addView(oldImage);

                    }
                    container.addView(dragItem);
                    dragItem.setVisibility(View.VISIBLE);
                    onImageDragged((ImageView) dragItem, oldImage, owner, container);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackground(normalShape);
                    if (!event.getResult()) {
                        dragItem.setX(initX);
                        dragItem.setY(initY);
                        dragItem.setVisibility(View.VISIBLE);
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    }

//    private class ItemAdapter {
//        Map<Item, ItemTag> map = new HashMap<>();
//
//        private void addItem(Item item, ItemTag tag) {
//            map.put(item, tag);
//        }
//
//        private ItemTag setTag(Item item, ItemTag tag) {
//            ItemTag oldTag = map.get(item);
//            map.remove(item);
//            map.put(item, tag);
//            return oldTag;
//        }
//
//        private ItemTag getTag(Item item) {
//            ItemTag tag = map.get(item);
//            return tag;
//        }
//    }
}
