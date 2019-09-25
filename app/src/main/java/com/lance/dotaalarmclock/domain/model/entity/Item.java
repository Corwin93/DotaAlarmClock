package com.lance.dotaalarmclock.domain.model.entity;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.util.UUID;

/**
 * Created by User on 10/29/2017.
 */

public class Item implements Comparable {
    private UUID id;
    private int imageResourceId;
    private int name;

    public Item (@StringRes int name, @DrawableRes int imageResourceId) {
        id = UUID.randomUUID();
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    protected Item() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        if(o instanceof Item) {
            return getId().compareTo(((Item)o).getId());
        } else {
            throw new IncompatibleClassChangeError("Comparable object is not an instance of Item.class");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof Item) && ((Item)obj).getImageResourceId() == this.getImageResourceId()) {
            return true;
        }
        return false;
    }
}
