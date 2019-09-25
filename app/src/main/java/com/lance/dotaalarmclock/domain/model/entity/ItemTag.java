package com.lance.dotaalarmclock.domain.model.entity;

import java.util.UUID;

/**
 * Created by Corwin on 27.10.2017.
 */

public class ItemTag {
    private Type type;
    private UUID id;

    public ItemTag(Type type, UUID id) {
        this.type = type;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return type.toString() + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null != obj) {
            if (this.getClass().isAssignableFrom(obj.getClass())) {
                if (type.equals(((ItemTag) obj).type) && id.equals(((ItemTag) obj).id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
