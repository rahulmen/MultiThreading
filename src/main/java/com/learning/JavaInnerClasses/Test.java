package com.learning.JavaInnerClasses;

import java.util.HashMap;
import java.util.Map;

public class Test {


  static String[] url = new String[]{"google","wiki","google","google","wiki","facebook","facebook","google"};

  //Output
  //google=3 wiki=2 facebook=1

  public static void main(String[] args) {

    Map<String,Integer> map = new HashMap<>();

    for(String str:url){

      if(map.containsKey(str)){
        map.put(str,map.get(str)+1);
      }else{
        map.put(str,1);
      }
    }

    System.out.println(map);
  }




}
