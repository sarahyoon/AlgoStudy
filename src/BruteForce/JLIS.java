package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JLIS  {

    static int[] a;
    static int[] b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int t=0;t<c;t++) {
            String st[] = br.readLine().split(" ");
            a = new int[Integer.parseInt(st[0])];
            b = new int[Integer.parseInt(st[1])];

            st = br.readLine().split(" ");

            for(int i=0; i<a.length; i++)
                a[i] = Integer.parseInt(st[i]);

            st = br.readLine().split(" ");
            for(int i=0; i<b.length; i++)
                b[i] = Integer.parseInt(st[i]);

            dp = new int[a.length+1][b.length+1];

            //초기화
            for(int i=0; i<a.length+1; i++) {
                for(int j=0; j<b.length+1; j++)
                    dp[i][j] = -1;
            }

            ans = getMax(-1,-1)-2;

            System.out.println(ans);
        }
    }

    static int getMax(int ai, int bi) {
        if(dp[ai+1][bi+1] != -1)
            return dp[ai+1][bi+1];

        long am = (ai == -1 ? Long.MIN_VALUE : (long)a[ai]);
        long bm = (bi == -1 ? Long.MIN_VALUE : (long)b[bi]);

        long max = Math.max(am, bm);

        int sum = 2;

        for(int i= ai+1; i<a.length; i++) {
            if(max < a[i])
                sum = Math.max(sum, getMax(i,bi)+1);
        }

        for(int i= bi+1; i<b.length; i++) {
            if(max < b[i])
                sum = Math.max(sum, getMax(ai,i)+1);
        }

        dp[ai+1][bi+1] = sum;

        return sum;
    }

}
