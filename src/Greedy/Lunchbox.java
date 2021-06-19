package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lunchbox {
     public static void main(String[] args){

         Scanner scan = new Scanner(System.in);

         int testCase = scan.nextInt();

         for(int i=0;i<testCase;i++){

             int n = scan.nextInt();

             int[][] lunchbox = new int[n][2];

             for(int j=0;j<n;j++) {
                 lunchbox[j][0] = scan.nextInt();
             }
             for(int j=0;j<n;j++) {
                 lunchbox[j][1] = scan.nextInt();
             }

             Arrays.sort(lunchbox, new Comparator<int[]>() {
                 @Override
                 public int compare(int[] o1, int[] o2) {
                     return o2[1]-o1[1];
                 }
             });

             int heat = 0;
             int result = 0;

             for(int j=0;j<n;j++){
                 heat += lunchbox[j][0];
                 result = Math.max(result, heat+lunchbox[j][1]);
             }

             System.out.println(result);
         }
     }

}
