package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class snail {
    public static int N;
    public static int M;
    public static double[][] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i=0; i<testCase; i++) {

            N = scan.nextInt(); //우물의 깊이
            M = scan.nextInt(); //장마 기간의 길이
            dp = new double[M][2*M]; //항상  0이상의 실수
            for(double[] k : dp)
                Arrays.fill(k, -1);
            System.out.println(solve(0, 0));
        }
    }

    private static double solve(int days, int climbed) {
        if(days == M)
            return climbed >= N ? 1 : 0;

        if(dp[days][climbed] != -1)
            return dp[days][climbed];

        return dp[days][climbed] = 0.75 * solve(days+1, climbed+2) + 0.25 * solve(days+1, climbed+1);
    }
}