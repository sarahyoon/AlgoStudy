package BruteForce;

import java.util.Scanner;

public class LC_1641 {

    static int[][] dp;
    static int n;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        dp = new int[n][5];

        System.out.println(count(0,0));

    }

    public static int count(int a, int b){

        if(a == n){
            if(n==0){
                return 0;
            }
            return 1;
        }

        if(dp[a][b]>0){
            return dp[a][b];
        }


        for(int i=0;i<5;i++){
            if(i>=b){
                dp[a][b] += count(a+1, i);
            }
        }

        return dp[a][b];

    }
}
