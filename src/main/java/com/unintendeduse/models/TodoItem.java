package com.unintendeduse.models;

import com.google.appengine.api.datastore.Text;
import com.vercer.engine.persist.annotation.Key;
import com.vercer.engine.persist.annotation.Type;

import java.util.Date;

public class TodoItem {
    @Key String task;
    @Type(Text.class) String taskDescription;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
