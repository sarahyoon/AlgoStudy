package BruteForce;

import java.util.Scanner;

public class Quadtree {

    public static String ans;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();

        for(int i=0;i<testCase;i++){
            ans = "";
            String pixel = scan.nextLine();

            ans = zip(pixel, 0);
            System.out.println(ans);
        }
    }

    public static String zip(String pix, int idx){


        if(idx >=pix.length()-1){
            return pix.charAt(idx)+"";
        }
        if(pix.charAt(idx) == 'x' ){

            if(idx+4>pix.length()-1){
                zip(pix, idx+3);
                zip(pix, idx+4);
                zip(pix, idx+1);
                zip(pix, idx+2);
                idx++;
            }

        }

        return "x"+pix.charAt(idx+3)+pix.charAt(idx+4)+pix.charAt(idx+1)+pix.charAt(idx+2);
    }
}
