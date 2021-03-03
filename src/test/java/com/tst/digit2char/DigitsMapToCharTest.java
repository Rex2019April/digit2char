package com.tst.digit2char;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitsMapToCharTest {
    @Test
    public void test() {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        DigitsMapToChar.digToString(a);

        List<Integer> b = new ArrayList<>();
        b.add(9);
        b.add(9);
        DigitsMapToChar.digToString(b);

        Integer[] c= {1,11, 88, 99};
        List<Integer> l = Arrays.asList(c);
        List<Integer> newList = new ArrayList<>();

        for(Integer i: l) {
            if(i>=10 && i<=99) {
                String j = i+"";
                if(j.contains("0") || j.contains("1")){
                    j = j.replace("0", "").replace("1", "");
                }
                if(j.length()==2){
                    String[] arr = j.split("");
                    for(String s: arr){
                        newList.add(Integer.parseInt(s));
                    }
                }else if(j.length()>0){
                    newList.add(Integer.parseInt(j));
                }
            }else {
                newList.add(i);
            }
        }
        DigitsMapToChar.digToString(newList);
    }
}
