package com.tst.digit2char;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilsTest {

    @Test
    public void test(){
        List<String> list1 = Arrays.asList("a", "f", "g");
        List<String> list2 = Arrays.asList("j", "k", "p");
        List<String> list0 = Arrays.asList("q", "r", "t");
        ArrayList<List<String>> list3 = new ArrayList<>();
        list3.add(list1);
        list3.add(list2);
        list3.add(list0);
        List<String> descartes = ArrayUtils.getPermutations(list3);
        for(String s: descartes) {
            System.out.printf("%s\t", s);
        }
//        descartes.forEach(System.out::println);
    }
}
