package amir.json.converter.service.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtilsTest {

    @Test
    public void testPartition(){

        List<List<String>> list = new ArrayList<>();

        List<String> testList = Arrays.asList("a","b","c","d","e","f","g","h","i","j");

        System.out.println("size of testList: "+ testList.size());

        System.out.println("target size: " + 2);
        List<List<String>> listOfLists1 = ListUtils.partition(testList, 2);
        for (List l : listOfLists1) {
            System.out.println("list1: "+ l);
        }

        System.out.println("target size: " + 3);
        List<List<String>> listOfLists2 = ListUtils.partition(testList, 3);
        for (List l : listOfLists2) {
            System.out.println("list2: "+ l);
        }

        System.out.println("target size: " + 15);
        List<List<String>> listOfLists3 = ListUtils.partition(testList, 15);
        for (List l : listOfLists3) {
            System.out.println("list3: "+ l);
        }
    }

}