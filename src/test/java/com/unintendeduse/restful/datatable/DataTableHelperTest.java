package com.unintendeduse.restful.datatable;

import com.google.common.collect.Lists;
import com.unintendeduse.models.TodoItem;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DataTableHelperTest {
    @Test
    public void shouldTransformListOfTodoItemsIntoAListOfListsOfFieldValues() {
        // The end result is a Json object that looks like this.
        // { "aaData" : [ [ "Gecko",
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

        List<TodoItem> todoItemList = Lists.newArrayList(bakeCake, buyFlour, gotoStore);
        List<List<String>> result = DataTableHelper.transformIntoListOfListOfStrings(todoItemList);

        assertThat(result.size(), equalTo(3));
        assertThat(result.get(0).get(0), equalTo("bake a cake"));
        assertThat(result.get(0).get(1), equalTo("a delicious chocolate cake"));
        assertThat(result.get(2).get(0), equalTo("goto store"));
        assertThat(result.get(2).get(1), equalTo("to buy flour"));

    }


}
