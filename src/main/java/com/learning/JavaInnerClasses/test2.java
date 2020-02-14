package com.learning.JavaInnerClasses;

public class test2 {

  public static void m1(){
    System.out.println(1);
  }

  public void m2(){
    System.out.println(2);
  }

}

class test3 extends test2{



  public static void m1(){
    System.out.println(3);
  }

  public void m2(){
    System.out.println(4);
  }


  public static void main(String[] args) {

    test2 t1 = new test3();
    t1.m2();
    test3 test3 = new test3();
    test3.m2();
    test2 test21 = new test2();
    test21.m2();


  }
}
