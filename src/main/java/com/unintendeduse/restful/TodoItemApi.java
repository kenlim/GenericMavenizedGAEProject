package com.unintendeduse.restful;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.unintendeduse.models.TodoItem;
import com.unintendeduse.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import java.util.Map;

@Path("/todo")
public class TodoItemApi {
    private Logger logger = LoggerFactory.getLogger(TodoItemApi.class);
    private TodoItemRepository todoItemRepository;

    @Inject
    public TodoItemApi(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @POST
    @Path("/create")
    @Produces("application/json")
    public TodoItem createNew(@FormParam("task") String task,
                              @FormParam("description") String description) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTask(task);
        todoItem.setTaskDescription(description);
        return todoItemRepository.save(todoItem);
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public TodoItem[] readAllTodoItems() {
        return Iterators.toArray(todoItemRepository.getAllTodoItems(), TodoItem.class);
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public TodoItem readTodoWithId(@PathParam("id") Long id) {
        return todoItemRepository.getTodoWithId(id);
    }

    @POST
    @Path("/{id}")
    @Produces("application/json")
    public TodoItem updateTodo(@PathParam("id") Long id,
                                @FormParam("task") String task,
                                @FormParam("description") String description) {
        TodoItem todoItem = readTodoWithId(id);
        todoItem.setTask(task);
        todoItem.setTaskDescription(description);
        return todoItemRepository.update(todoItem);

    }

    @POST
    @Path("/{id}/delete")
    @Produces("application/json")
    public Map<String, String> deleteTodo(@PathParam("id") Long id) {
        todoItemRepository.deleteTodo(id);
        return ImmutableMap.of("Status", "OK", "Deleted item", "id");
    }
}