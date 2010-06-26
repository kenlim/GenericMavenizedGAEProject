package com.unintendeduse.twigpersist;

import com.google.appengine.api.datastore.Text;
import com.vercer.engine.persist.annotation.Type;

public class TwiggyTitle {
    String name;
    @Type(Text.class) String description;
    int index;
    int page;
    String image;
    boolean unlockedByDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isUnlockedByDefault() {
        return unlockedByDefault;
    }

    public void setUnlockedByDefault(boolean unlockedByDefault) {
        this.unlockedByDefault = unlockedByDefault;
    }
}
