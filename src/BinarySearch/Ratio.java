package BinarySearch;

import java.util.Scanner;

public class Ratio {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            double n = scan.nextInt();
            double m = scan.nextInt();

            int percent = (int) (m* 100 / n);

            if(percent == 100){
                System.out.println(-1);
                continue;
            }

            int ans =(int)Math.ceil ((n*(percent + 1) - 100*m)/(100-(percent+1)));

            if(ans >=0 && ans<= 2000000000 ){
                System.out.println(ans);
            }else{
                System.out.println(-1);
                continue;
            }
        }


    }
}
