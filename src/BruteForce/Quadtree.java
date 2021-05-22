package BruteForce;

import java.util.Scanner;

public class Quadtree {

    public static String ans;

    public static int idx;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();
        ans = "";

        for(int i=0;i<testCase;i++){
            String pixel = scan.nextLine();
            idx = 0;
            ans += zip(pixel)+"\n";
        }
        System.out.println(ans);

    }

    public static String zip(String pix){


        if(pix.charAt(idx) != 'x'){
            return pix.charAt(idx++)+"";
        }
        idx++;
        String first = zip(pix);

        String second = zip(pix);

        String third = zip(pix);

        String fourth = zip(pix);

        return 'x'+third + fourth + first + second;

    }
}
