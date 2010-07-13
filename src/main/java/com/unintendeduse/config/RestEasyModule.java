package com.unintendeduse.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.unintendeduse.restful.TodoItemApi;
import com.vercer.engine.persist.ObjectDatastore;
import com.vercer.engine.persist.annotation.AnnotationObjectDatastore;

public class RestEasyModule implements Module {
    public void configure(final Binder binder) {
        binder.bind(TodoItemApi.class);
    }

    @Provides
    ObjectDatastore getObjectDatastore() {
        return new AnnotationObjectDatastore();
    }
}