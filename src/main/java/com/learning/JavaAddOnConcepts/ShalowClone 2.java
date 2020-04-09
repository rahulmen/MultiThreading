package com.learning.JavaAddOnConcepts;

/*
* Shallow copy is method of copying an object and is followed by default in cloning.
* In this method the fields of an old object X are copied to the new object Y.
* While copying the object type field the reference is copied to Y i.e object Y will point to same location as pointed out by X.
* If the field value is a primitive type it copies the value of the primitive type.
Therefore, any changes made in referenced objects in object X or Y will be reflected in other object.
 */

class BaseClass{
    int a,b;
}

 class Test implements Cloneable{

    int i;
    int j;

    BaseClass baseClass = new BaseClass();


    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}


public class ShalowClone {


    public static void main(String... args) throws CloneNotSupportedException{

        //first Object of test class
        Test test1 = new Test();
        test1.i=10;
        test1.j=20;
        test1.baseClass.a=30; //This will be common for both test1 and test2 this is shallow copy.
        test1.baseClass.b=40;

        //Second object of test class
        Test test2 = (Test)test1.clone(); //as it will return object of Object Class we have to perform casting

        test2.i=30;
        test2.baseClass.a=70;

        if(test1==test2){
            throw new RuntimeException("Clonning not acheived");
        }

        if(test1.baseClass.a==test2.baseClass.a){
            System.err.println("Only Shallow Copy acheived");
        }else{
            System.out.println("Deep Copy Acheived");
        }


        //Changes refelcted in baseClass instance member will be reflected in both instance member test1 and test2

        System.out.print("Sum of test1 intance memebers value :"+(test1.i+test1.j+test1.baseClass.a+test1.baseClass.b)+"\n");
        System.out.print("Sum of test2 intance memebers value :"+(test2.i+test2.j+test2.baseClass.a+test2.baseClass.b));


    }

}
