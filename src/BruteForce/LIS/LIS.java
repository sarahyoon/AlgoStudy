package BruteForce.LIS;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {

    static int[] a;
    static int[] cache;
    static int n;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            n = scan.nextInt();

            a = new int[n];
            cache = new int[n+1];
            Arrays.fill(cache, -1);

            for(int k=0;k<n;k++){
                a[k] = scan.nextInt();
            }

            System.out.println(lis(-1)-1);
        }

    }

    public static int lis(int start){

            if(cache[start+1] != -1){
                return cache[start+1];
            }

            cache[start+1] = 1;

            for(int next = start+1;next<n;++next){
                if(start == -1 || (a[start]<a[next])){
                    cache[start+1] = Math.max(cache[start+1], lis(next)+1);
                }
            }
        return cache[start+1];

    }
}
