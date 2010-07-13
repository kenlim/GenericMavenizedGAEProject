package com.unintendeduse.models;

import com.google.appengine.api.datastore.Text;
import com.vercer.engine.persist.annotation.Key;
import com.vercer.engine.persist.annotation.Type;

import java.util.Date;

public class TodoItem {
    @Key String task;
    @Type(Text.class) String taskDescription;
}
