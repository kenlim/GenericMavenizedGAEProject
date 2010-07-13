package com.unintendeduse.restful;

import com.google.inject.Inject;
import com.unintendeduse.models.TodoItem;
import com.unintendeduse.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;

@Path("/todo")
public class TodoItemApi {
    private Logger logger = LoggerFactory.getLogger(TodoItemApi.class);
    private TodoItemRepository stackRepository;

    @Inject
    public TodoItemApi(TodoItemRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    @POST
    @Path("/create")
    @Produces("application/json")
    public TodoItem createNew(@FormParam("name") String name,
                              @FormParam("description") String description) {
        return null;
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Object readAllTodoItems() {
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public TodoItem readTodoWithId(@PathParam("id") Long id) {
        return null;
    }

    @POST
    @Path("/{id}")
    @Produces("application/json")
    public TodoItem updateTodo(@PathParam("id") Long id,
                                @FormParam("name") String name,
                                @FormParam("description") String description) {

        return null;
    }

    @POST
    @Path("/{id}/delete")
    @Produces("application/json")
    public TodoItem deleteTodo(@PathParam("id") Long id) {

        return null;
    }
}