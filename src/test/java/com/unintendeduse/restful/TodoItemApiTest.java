package com.unintendeduse.restful;

import com.unintendeduse.models.TodoItem;
import com.unintendeduse.repositories.TodoItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoItemApiTest {
    private TodoItemApi todoItemApi;
    private TodoItemRepository mockStackRepo;

    @Before
    public void setUp() {
        mockStackRepo = mock(TodoItemRepository.class);
        todoItemApi = new TodoItemApi(mockStackRepo);
    }

    @Test
    public void shouldPassTodoObjectMatchingProvidedArgsToRepository() {
        TodoItem todoItem = new TodoItem();
        when(mockStackRepo.save(argThat(new TodoMatcher("bake cake", "a delicious chocolate cake"))))
                .thenReturn(todoItem);

        TodoItem returnedTodo = todoItemApi.createNew("bake cake", "a delicious chocolate cake");
        assertThat(returnedTodo, equalTo(todoItem));
    }




    class TodoMatcher extends ArgumentMatcher<TodoItem> {
        private String task;
        private String description;

        public TodoMatcher(String task, String description) {
            super();
            this.task = task;
            this.description = description;
        }

        @Override
        public boolean matches(Object other) {
            if (other.getClass() != TodoItem.class) {
                return false;
            }
            TodoItem otherStack = (TodoItem) other;
            if (otherStack.getTask().equals(task) && otherStack.getTaskDescription().equals(description)) {
                return true;
            }
            return false;
        }
    }
}
