package com.tst.digit2char;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  ArrayUtils {
    /**
     * 多个数组排列组合
     * @param list 原始list
     * @param <T> 数据类型
     * @return
     */
    private static <T> List<List<T>> getDescartes(List<List<T>> list) {
        List<List<T>> returnList = new ArrayList<>();
        descartesRecursive(list, 0, returnList, new ArrayList<T>());
        return returnList;
    }

    /**
     * 递归实现
     * 原理：从原始list的0开始依次遍历到最后
     *
     * @param originalList 原始list
     * @param position     当前递归在原始list的position
     * @param returnList   返回结果
     * @param cacheList    临时保存的list
     */
    private static <T> void descartesRecursive(List<List<T>> originalList, int position, List<List<T>> returnList, List<T> cacheList) {
        List<T> originalItemList = originalList.get(position);
        for (int i = 0; i < originalItemList.size(); i++) {
            //最后一个复用cacheList，节省内存
            List<T> childCacheList = (i == originalItemList.size() - 1) ? cacheList : new ArrayList<>(cacheList);
            childCacheList.add(originalItemList.get(i));
            if (position == originalList.size() - 1) {//遍历到最后退出递归
                returnList.add(childCacheList);
                continue;
            }
            descartesRecursive(originalList, position + 1, returnList, childCacheList);
        }
    }

    /**
     * 多个数组排列组合
     * @param list 原始list
     * @return
     */
    public static List<String> getPermutations(List<List<String>> list) {
        List<String> resultList = new ArrayList<>();
        List<List<String>> list1 = getDescartes(list);
        if(list1!=null && list1.size()>0){
            list1.forEach(temp->{
                String str = listToStr(temp);
                if (str!=null && str.length()>0) {
                    resultList.add(listToStr(temp));
                }
            });
        }
        return resultList;
    }

    public static String listToStr(List<String> list){
        StringBuffer str = new StringBuffer();
        if(list!=null && list.size()>0){
            list.forEach(temp->{
                str.append("").append(temp).append("");
            });
        }
        return str.toString();
    }
    
    public static void main(String[] args){
        List<String> list1 = Arrays.asList("a", "f", "g");
        List<String> list2 = Arrays.asList("j", "k", "p");
        List<String> list0 = Arrays.asList("q", "r", "t");
        ArrayList<List<String>> list3 = new ArrayList<>();
        list3.add(list1);
        list3.add(list2);
        list3.add(list0);
        List<String> descartes = getPermutations(list3);
        for(String s: descartes) {
        	System.out.printf("%s\t", s);
        }
//        descartes.forEach(System.out::println);
    }

}
