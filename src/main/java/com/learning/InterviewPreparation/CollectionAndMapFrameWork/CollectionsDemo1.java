package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo1 {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(4,5,2,4,3,2,4,4,2,3,42,4,43,34));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //Collections.rotate(list,2);

        //System.out.println(list);

        System.out.println(Collections.binarySearch(list,22));

    }

}
