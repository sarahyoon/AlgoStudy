package BinarySearch;

public class search {

    public static void main(String[] args){

        int[] arr = {1, 5, 7, 29, 60, 102, 125};

        int num = 102;

        System.out.println(binarySearch(arr, num));
    }

    public static int binarySearch(int[] arr, int num){
        int left = 0;
        int right = arr.length-1;


        while(left<=right){

            int mid = (right+left)/2;

            if(arr[mid] == num){
                return mid;
            }

            else if(arr[mid]<num){
                left = mid+1;
            }
            else if(arr[mid]>num){
                right = mid-1;
            }

        }

        return -1;
    }
}
