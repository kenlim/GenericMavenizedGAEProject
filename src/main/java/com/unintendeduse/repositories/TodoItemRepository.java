package com.unintendeduse.repositories;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.inject.Inject;
import com.unintendeduse.models.TodoItem;
import com.vercer.engine.persist.ObjectDatastore;

public class TodoItemRepository {
    private ObjectDatastore datastore;

    @Inject
    public TodoItemRepository(ObjectDatastore datastore) {

        this.datastore = datastore;
    }

    public TodoItem save(TodoItem todoItem) {
        Key key = datastore.store(todoItem);
        return datastore.load(key);
    }


    public QueryResultIterator<TodoItem> getAllTodoItems() {
        return datastore.find().type(TodoItem.class).returnResultsNow();
    }

    public TodoItem getTodoWithId(Long id) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public TodoItem update(TodoItem todoItem) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public void deleteTodo(Long id) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
