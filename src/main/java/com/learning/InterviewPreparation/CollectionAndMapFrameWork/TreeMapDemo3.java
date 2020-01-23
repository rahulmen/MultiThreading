package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import org.testng.annotations.Test;

import java.io.ObjectInput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo3 {


    class MyComparator6 implements Comparator {

        @Override
        public int compare(Object obj1,Object obj2){

            Integer itr1 = (Integer)obj1.hashCode();
            Integer itr2 = (Integer)obj2.hashCode();
            return -itr1.compareTo(itr2);
        }


    }

    static class K implements Comparable{
        int id;
        K(Integer id){this.id=id;};

        @Override
        public String toString(){
            return "K-Object"+id;
        }

        @Override
        public int hashCode(){
            return id;
        }


        @Override
        public int compareTo(Object o) {

            K k = (K)o;
            Integer integer = k.id;
         return integer.compareTo(this.id);

        }
    }


    static class V{
        int id;
        V(Integer id){this.id =id;};

        @Override
        public String toString(){
            return "V-Object"+id;
        }

        @Override
        public int hashCode(){
            return id ;
        }

    }



    @Test
    public void testTreeMapUsingDefaultSorting(){

        TreeMap<K,V> map = new TreeMap<K,V>();
        map.put(new K(1),new V(01));
        map.put(new K(2),new V(02));
        map.put(new K(3),new V(03));


    }

    @Test
    public void testTreeMapUsingCustomisedSorting(){


        TreeMap<K,V> map1 = new TreeMap<K,V>(new MyComparator6());
        map1.put(new K(1),new V(01));
        map1.put(new K(2),new V(02));
        map1.put(new K(3),new V(03));


    }





}


