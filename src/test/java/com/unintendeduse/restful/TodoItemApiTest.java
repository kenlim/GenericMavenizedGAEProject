package com.unintendeduse.restful;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
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

    @Test
    public void shouldGenerateAMapThatIsCompatibleWithTheDatatable() {
        //{ "aaData" : [ [ "Gecko",
        //        "Firefox 1.0",
        //        "Win 98+ / OSX.2+",
        //        "1.7",
        //        "A"
        //      ],
        //      [ "Gecko",
        //        "Firefox 1.5",
        //        "Win 98+ / OSX.2+",
        //        "1.8",
        //        "A"
        //      ],
        //      [ "Gecko",
        //        "Firefox 2.0",
        //        "Win 98+ / OSX.2+",
        //        "1.8",
        //        "A"
        //      ]]}

        TodoItem bakeCake = new TodoItem();
        bakeCake.setTask("bake a cake");
        bakeCake.setTaskDescription("a delicious chocolate cake");

        TodoItem buyFlour = new TodoItem();
        buyFlour.setTask("buy flour");
        buyFlour.setTaskDescription("to make cake");

        TodoItem gotoStore = new TodoItem();
        gotoStore.setTask("goto store");
        gotoStore.setTaskDescription("to buy flour");

//        when(mockStackRepo.getAllTodoItems()).thenReturn();


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
