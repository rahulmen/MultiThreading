package com.learning.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList2 {


    public static void main(String[] args){


        Integer[] arr = {0,0,0,0,0,0};

       List<Integer> list = new ArrayList<>();
       list = Arrays.asList(arr);
       System.out.print(list);
    }

}
