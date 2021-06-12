package BruteForce.NumberGame;

import java.util.Arrays;
import java.util.Scanner;

public class numberGame {


    static int[] board;
    static int[][] dp;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int num = scan.nextInt();
            board = new int[num];

            for(int j=0;j<num;j++){
                board[j] = scan.nextInt();
            }

            dp = new int[num][num];
            for(int [] a: dp){
                Arrays.fill(a, -1);
            }

            System.out.println(play(0, num-1));

        }
    }

    public static int play(int left, int right){

        if(left>right){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }


        if(Math.abs(left-right) == 0){
            dp[left][right] = board[left];
        }
        else{

            int choice1 = Math.max(board[left] - play(left+1, right), board[right] - play(left, right-1));
            int choice2 = Math.max(-play(left+2, right), -play(left, right-2));
            dp[left][right] = Math.max( choice1, choice2);
        }

        return dp[left][right];
    }
}
