package BruteForce.PI;

import java.io.*;
import java.util.Arrays;

public class PI {

    static int INF = 987654321;
    static String N ;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for(int t=0; t<testCase; t++){

            N = br.readLine().trim();
            dp = new int[N.length()];
            Arrays.fill(dp, -1);

            bw.flush();
            bw.write(memorize(0) + "\n");

        }
        bw.close();
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
                ret = Math.min(ret, memorize(begin+i) + classify(begin, begin+i));
            }
        }
        dp[begin] = ret;

        return ret;
    }

    public static int classify(int a, int b){

        String M = N.substring(a, b);

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


        Boolean progressive = true;
        int diff = (M.charAt(1)) - (M.charAt(0));
        for(int i=2;i<M.length();i++){
            if(diff != (M.charAt(i)) - (M.charAt(i-1))){
                progressive = false;
                break;
            }
        }

        if(progressive && (diff == 1 || diff == -1 )){
            return 2;
        }
        else if(progressive){
            return 5;
        }


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

        return 10;
    }

}
