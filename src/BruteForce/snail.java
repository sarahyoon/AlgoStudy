package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class snail {

    static Double[][] dp;
    static int days;
    static int height;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){
            height = scan.nextInt();
            days = scan.nextInt();

            dp = new Double[days][height];
            for(Double[] a: dp){
                Arrays.fill(a,-1.0);
            }
            System.out.println(snail(height, days));
        }

    }

    public static Double snail(int h, int d){

        if(d == days){
            if(h>=height){
                return 1.0;
            }
            return 0.0;
        }

        if(dp[d][h] != -1.0){
            return dp[d][h];
        }
        return dp[d][h] = (snail(h+2, d+1) * 0.75) + (snail(h+1, d+1) * 0.25);

    }
}
