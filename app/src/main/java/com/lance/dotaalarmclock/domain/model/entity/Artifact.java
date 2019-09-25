package com.lance.dotaalarmclock.domain.model.entity;

import android.support.annotation.IdRes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 10/29/2017.
 */

public class Artifact extends Item {
    private List<Item> mCompositeItemList;

    private Artifact() {
        super();
        mCompositeItemList = new LinkedList<>();
    }

    public Artifact(@IdRes int name, @IdRes int imageResourceId) {
        super(name, imageResourceId);
        mCompositeItemList = new LinkedList<>();
    }

    public Artifact(int name, int imageResourceId, List<Item> compositeItemList) {
        super(name, imageResourceId);
        compositeItemList = new LinkedList<>();
        this.mCompositeItemList.addAll(compositeItemList);
    }

    public List<Item> getCompositeItemList() {
        return mCompositeItemList;
    }

    public void setCompositeItemList(List<Item> compositeItemList) {
        this.mCompositeItemList.addAll(compositeItemList);
    }

    public int getItemsCount() {
        return mCompositeItemList.size();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Artifact artifact = new Artifact();

        public Builder setName(int name) {
            artifact.setName(name);
            return this;
        }

        public Builder setImageResourceId(int imageResourceId) {
            artifact.setImageResourceId(imageResourceId);
            return this;
        }

        public Builder addItem(Item item) {
            artifact.mCompositeItemList.add(item);
            return this;
        }

        public Builder addItemList(List<Item> itemList) {
            artifact.mCompositeItemList.addAll(itemList);
            return this;
        }

        public Artifact build() {
            return artifact;
        }
    }
}
