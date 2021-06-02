package BruteForce.Asymtiling;

import java.util.Arrays;
import java.util.Scanner;

public class Asymtiling {

    static int[] cache;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int n = scan.nextInt();

            cache = new int[n+1];

            Arrays.fill(cache, -1);

            System.out.println(asymtiling(n));
        }
    }

    public static int asymtiling(int width){

        if(width %2 == 1){
            return (tiling(width)-tiling(width/2)+1000000007) % 1000000007;
        }

        int result = tiling(width);
        result = (result - tiling(width/2) + 1000000007) % 1000000007;
        result = (result - tiling(width/2 -1) + 1000000007) % 1000000007;

        return result;
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
