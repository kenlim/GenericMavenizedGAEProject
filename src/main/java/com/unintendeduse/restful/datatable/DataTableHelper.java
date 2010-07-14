package com.unintendeduse.restful.datatable;

import com.google.common.collect.Lists;
import com.unintendeduse.models.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class DataTableHelper {
    public static List<List<String>> transformIntoListOfListOfStrings(List<TodoItem> list) {
        ArrayList<List<String>> bigList = Lists.newArrayList();
        for (TodoItem item : list) {
            bigList.add(Lists.<String>newArrayList(item.getTask(), item.getTaskDescription()));
        }

        return bigList;
    }
}
