package BruteForce.LIS;

import java.util.Scanner;

public class LIS {

    static String ans;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        ans = "";
        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int n = scan.nextInt();

            int [] a = new int[n];

            for(int k=0;k<n;k++){
                a[k] = scan.nextInt();
            }

            int[] dp= new int[n];

            for(int k=0;k<n;k++){
                dp[k] = 1;
                for(int j=0;j<k;j++){
                    if(a[j] < a[k] && dp[k] < dp[j]+1){
                        dp[k] = dp[j]+1;
                    }
                }
            }

            int result = dp[0];
            for(int k=0;k<n;k++){
                if(result<dp[k]){
                    result = dp[k];
                }
            }

            ans += result + "\n";

        }

        System.out.println(ans);
    }
}
