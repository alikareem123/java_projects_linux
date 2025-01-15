package com.generics_extra.util;

import java.util.ArrayList;
import java.util.List;

import com.generics_extra.model.Student;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T> { // more restrictive
    // private List<T> items;

    public QueryList() {

    }

    public QueryList(List<T> items) {
        super(items);
        // this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();

        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();

        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
