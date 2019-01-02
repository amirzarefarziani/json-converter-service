package amir.json.converter.service.utils;

import java.util.ArrayList;
import java.util.List;

class ListUtils {

    static <T> List<List<T>> partition(List<T> list, int size) {

        List<List<T>> lists = new ArrayList<>();

        int start = 0;
        int end = size;

        do {
            if (end > list.size()) {
                end = list.size();
            }
            lists.add(list.subList(start, end));
            start=end;
            end+=size;
        } while (start < list.size());

        return lists;
    }
}
