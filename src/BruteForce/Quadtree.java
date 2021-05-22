package BruteForce;

import java.util.Scanner;

public class Quadtree {

    public static String str;
    public static int idx;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();

        for(int i=0;i<testCase;i++){
            str = scan.nextLine();
            idx = 0;
            System.out.println(zip());
        }

    }

    public static String zip(){


        if(str.charAt(idx) != 'x'){
            return str.charAt(idx++)+"";
        }

        idx++;
        String first = zip();

        String second = zip();

        String third = zip();

        String fourth = zip();

        return 'x'+third + fourth + first + second;
    }
}
