package BruteForce.TrianglePath;

import java.util.Scanner;

public class TrianglePath {

    static int[][] paths = new int[100][100];
    static int n;
    static int[][] dp = new int[100][100];

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        String ans = "";
        for(int i=0;i<testCase;i++){

            int lines = scan.nextInt();
            n= lines;
            for(int r=0;r<lines;r++){
                for(int c=0;c<=r;c++){
                    paths[r][c] = scan.nextInt();
                    dp[r][c] = -1;
                }
            }

            ans += path(0,0) + "\n";
        }
        System.out.println(ans);
    }

    public static int path(int y, int x ){

        if(y == n-1)
            return paths[y][x];

        if(dp[y][x] != -1)
            return dp[y][x];

        return dp[y][x] = Math.max(path(y+1,x), path(y+1, x+1)) + paths[y][x];
    }
}

