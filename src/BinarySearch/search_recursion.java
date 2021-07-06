package BinarySearch;

import Sort.KNum;

import java.util.Enumeration;

public class search_recursion {

    public static int[] arr = {1, 5, 7, 29, 60, 102, 125};

    public static int num = 7;

    public static void main(String[] args){

        int left = 0;
        int right = arr.length-1;

        System.out.println(binarySearch(left, right));
    }

    public static int binarySearch(int left, int right){

        if(left<=right){

            int mid = (left+right)/2;

            if (arr[mid] == num){
                return mid;
            }

            if(arr[mid] < num){
               return binarySearch(mid+1, right);
            }

            if(arr[mid] > num){
               return binarySearch(left, mid-1);
            }
        }

        return -1;
    }
}
