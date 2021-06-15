package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MatchOrder {

    static int[] rus;
    static int[] kor;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int player = scan.nextInt();

            rus = new int[player];
            kor = new int[player];

            for(int p = 0;p<player;p++){
                rus[p] = scan.nextInt();
            }

            for(int p=0;p<player;p++){
                kor[p] = scan.nextInt();
            }

           System.out.println(matchOrder());

        }

    }

    public static int matchOrder(){
        Arrays.sort(rus);
        Arrays.sort(kor);
        int count = 0;

        int j = kor.length-1;
        for(int i=kor.length-1;i>=0;i--){
            if(kor[j] >= rus[i] ){
                count++;
                j--;
            }
        }
        return count;
    }

    public static void print() {
        for(int i=0;i<rus.length;i++){
            System.out.print(rus[i]);
        }

        System.out.println();
        for(int j=0;j<kor.length;j++){
            System.out.print(kor[j]);
        }
    }
}
