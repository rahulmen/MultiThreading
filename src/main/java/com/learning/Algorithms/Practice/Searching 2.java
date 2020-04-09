package com.learning.Algorithms.Practice;

public class Searching {

    public static int arr[] = new int[]{12,14,19,21,28,34,39,43,49,54,59,63,66,69,73,78,84,88,89,93,97};

    /*
    *Binary Search Method
     */

    public static int binarySearch(int min,int max,int find){

        int mid = (min+max)/2;

        if(max>=0) {
            if(arr[mid]==find){
                return mid;
            }
            else if (find > arr[mid]) {
                return binarySearch(mid + 1, max, find);
            } else if (find < arr[mid]) {
                return binarySearch(0, mid - 1, find);
            }
        }
        return -1;
    }

    /*
    *ternary Search Method
     */

    public static int ternarySearch(int min,int max,int find){

        int mid1= min+(max-min)/3;
        int mid2 = max-(max-min)/3;

        if(max>=0){
            if(arr[mid1]==find){
                return mid1;
            }
            if(arr[mid2]==find){
                return mid2;
            }
            if(find<arr[mid1]){
                return ternarySearch(0,mid1-1,find);
            }
            else if(find>arr[mid2]){
                return ternarySearch(mid2+1,max,find);
            }
            else{
                return ternarySearch(mid1+1,mid2-1,find);
            }


        }

        return -1;
    }


    public static void main(String[] args){

        for(int i=0;i<arr.length;i++) {
            System.out.print(binarySearch(0, arr.length - 1, arr[i]));
            System.out.print(ternarySearch(0, arr.length - 1, arr[i]));
        }



    }

}
