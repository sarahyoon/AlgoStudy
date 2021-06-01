package BruteForce.Tiling2;

import java.util.Arrays;
import java.util.Scanner;

public class Tiling2 {

    static int[] cache;
    public static void main(String[] args){

        String ans = "";
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int n = scan.nextInt();
            cache = new int[n+1];
            Arrays.fill(cache, -1);

            System.out.println(tiling(n));
            // ans = tiling(n) + "\n";
        }

        // System.out.println(ans);
    }

    public static int tiling(int width){

        if(width<=1){
            return 1;
        }
        if(cache[width] != -1){
            return cache[width];
        }

        return cache[width] = (tiling(width-1) + tiling(width-2)) % 1000000007;
    }
}
