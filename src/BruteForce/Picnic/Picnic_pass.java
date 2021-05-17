package BruteForce.Picnic;

import java.util.Scanner;


public class Picnic_pass {

    public static boolean[][] areFriends;
    public static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String result = "";
        for(int j = 0; j<count; j++){
            n = sc.nextInt();
            int friendCount = sc.nextInt();
            areFriends = new boolean[10][10];
            for(int i=0; i<friendCount; i++){
                int a=sc.nextInt();
                int b = sc.nextInt();

                areFriends[a][b] = areFriends[b][a] = true;
            }
            boolean[] data = new boolean[10];
            result +=(j+1==count)?countPairings(data):countPairings(data)+"\n";
        }
        System.out.println(result);

    }

    private static int countPairings(boolean[] taken){
        int firstFree =-1;

        for(int i=0; i<n; ++i){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }

        if(firstFree == -1)
            return 1;

        int ret = 0;
        for(int pairWith = firstFree+1; pairWith <n; ++pairWith){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }


}