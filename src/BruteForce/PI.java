package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class PI {

    static int[] dp;
    static String N;
    static int max = 12345678;


    public static void main(String[] args){

        String ans = "";
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        scan.nextLine();

        for(int i=0;i<testCase;i++){

            N = scan.nextLine();

            dp = new int[N.length()];

            Arrays.fill(dp, -1);
            ans += memorize(0) + "\n";
        }

        System.out.println(ans);
    }

    static int memorize(int begin) {
        if(begin == N.length()) return 0;

        int ret = dp[begin];
        if(ret != -1) return ret;
        ret = max;

        for(int L=3; L<=5; L++) {
            if(begin+L <= N.length())
                ret = Math.min(ret, memorize(begin+L) + classify(begin, begin+L-1));
        }

        return ret;
    }

    static int classify(int a, int b) {
        String M = N.substring(a, b+1);
        String s = "";

        for(int i=0; i<M.length(); i++)
            s += M.charAt(0);

        if(M.equals(s)) return 1;

        boolean progressive = true;
        for(int i=1; i<M.length(); i++) {
            if(M.charAt(i)-M.charAt(i-1) != M.charAt(1)-M.charAt(0)) {
                progressive = false;
                break;
            }
        }


        if(progressive && Math.abs(M.charAt(1)-(int)M.charAt(0)) == 1)
            return 2;

        boolean alternative = true;
        for(int i=0; i<M.length(); i++) {
            if(M.charAt(i) != M.charAt(i%2)) {
                alternative = false;
                break;
            }
        }

        if(alternative) return 4;
        if(progressive) return 5;

        return 10;

    }
}
