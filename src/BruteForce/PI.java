package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class PI {

    static int INF = 987654321;
    static String N ;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();

        for(int t=0; t<testCase; t++){

            N = scan.nextLine();
            dp = new int[N.length()];
            Arrays.fill(dp, -1);

            System.out.println(memorize(0));
        }
    }


    public static int memorize(int begin) {

        if(begin == N.length()){
            return 0;
        }


        if(dp[begin] != -1){
            return dp[begin];
        }

        int ret = INF;

        for(int i = 3;i<=5;i++){
            if(begin+i <= N.length()){
                ret = dp[begin] = Math.min(ret, memorize(begin+i) + classify(begin, begin+i-1));
            }
        }

        return ret;
    }

    public static int classify(int a, int b){

        String M = N.substring(a, b+1);

        // level 1: all elements are same.
        Boolean isSame = true;
        for(int i=0;i<M.length();i++){
            if(M.charAt(0) != M.charAt(i)) {
                isSame = false;
                break;
            }
        }

        if(isSame){
            return 1;
        }


        // level 2: Either numbers are increasing or decreasing by 1.
        Boolean progressive = true;
        int diff = M.charAt(1) - M.charAt(0);
        for(int i=0;i<M.length()-1;i++){
            if(diff != M.charAt(i+1) - M.charAt(i)){
                progressive = false;
                break;
            }
        }

        if(progressive && (diff == 1 || diff == -1 )){
            return 2;
        }

        // level 5: Numbers are increasing / decreasing in same diff.
        if(progressive){
            return 5;
        }

        // level 4: 2 numbers are alternative
        Boolean alternative = true;
        for(int i=0;i<M.length();i++){
            if(M.charAt(i) != M.charAt(i%2)){
                alternative = false;
                break;
            }
        }

        if(alternative){
            return 4;
        }

        //or else
        return 10;

    }


}
