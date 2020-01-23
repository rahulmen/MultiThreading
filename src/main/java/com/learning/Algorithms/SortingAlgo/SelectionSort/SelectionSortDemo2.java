package com.learning.Algorithms.SortingAlgo.SelectionSort;

/*
Selection Sort is one of the sorting technique to Sort an Array.

Example :- int[] arr = {2,1,3,5,4}

In above Example :-
1.We will use two pointer consider i,j
2.We will iterate i from 0 to array length-1 because last element left in the array is already the
  minimum element.
3. We will iterate j from i to array Length and in each iteration we will find the minimum element

Note :- For sorting the array using Selection Sort we will use one int vaiable(minElement) and for each iteration we will consider
i as the min element.

T(n) = O(n^2)

Explanation :-

for( i=0 to arr.length-1)                  (this statement will be executed n times)
set minIndex as i                          (this statement will be executed n-1 times)
for(j =i+1 to arr.length)                  (this complete for loop will be executed (n-1)+(n-2)+(n-3)+.....+1 times) ~~ n(n+1)/2
{
if(mindex value is greater than j index value)
set mindex as j index
}
swap the mindex value with i index value //this will be executed n-1 times

O(n) = C1.n + C2.(n(n+1)/2)+C3.(n-1)+C4.(n-1)

O(n)=T(n2)

 */


public class SelectionSortDemo2 {

    public static void main(String... args){

        int[] arr = {3,1,7,5,6,9,8,2,10,2,3,4,3443,22444,65432,45322,1234,4,64333};

        for(int i=0;i<arr.length-1;i++){

            int minIndex = i;

            for(int j=i+1;j<arr.length;j++){

                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            {
                //Write Swap Program here
                int temp = arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }

        }

        for(int arr1:arr){
            System.out.print(arr1+" ");
        }



    }

}
