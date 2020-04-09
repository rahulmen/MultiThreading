package com.learning.JavaStreamAPI;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreamDemo1 {

    public static void main(String... args){

        Integer[] a = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(a);

        System.out.println(list);

        list=list.stream().map(x->x*x).collect(Collectors.toList());

        System.out.println(list);

        list = list.subList(2,4).stream().map(x->x+x).collect(Collectors.toList());



        System.out.println(list);

    }


}
