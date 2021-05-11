package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class picnic {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        int num_of_std =0;
        int f_pair = 0;
        String friends = "";

        for(int i=0;i<testCase;i++){
            scan.nextLine();

            String cases = scan.nextLine();

            num_of_std = Integer.parseInt(cases.split(" ")[0]);
            f_pair = Integer.parseInt(cases.split(" ")[1]);
            friends = scan.nextLine();

            solve(num_of_std, f_pair, friends);
        }

    }

    public static int solve(int num_of_std, int f_pair, String friends){

        int team = num_of_std/2;

        if(team == f_pair){
            return 1;
        }

        int arr[][] = setnewArray(friends, num_of_std);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        int answer = 0;

        for(int i=0;i<arr.length;i++){
            for(int j= 0;j<arr[0].length;j++){

                if(arr[i][j] == 1){
                    int[][] copy = setnewArray(friends, num_of_std);
                    System.out.println(i+","+j);

                    copy[i][j] = -1;

                    answer+= check(copy,i, j, team-1);
                    System.out.println("answer" + answer);

                }
            }
        }
        System.out.println(answer);
        return 0;
    }

    public static int[][] setnewArray(String friends, int num_of_std){

        int[][] arr = new int[num_of_std][num_of_std];
        String pairs[] = friends.split(" ");
        for(int i=0;i<pairs.length-1;i+=2){
            int first = Integer.parseInt(pairs[i]);
            int second = Integer.parseInt(pairs[i+1]);

            arr[first][second] = 1;
        }

        return arr;
    }

    public static int[][] setMinus(int[][] copy, int x, int y){
        for(int i=0;i<copy.length;i++){
            copy[x][i] = -1;
        }
        for(int i=0;i<copy.length;i++){
            copy[y][i] = -1;
        }
        for(int i = 0;i<copy.length;i++){
            copy[i][x] = -1;
        }
        for(int i=0;i<copy.length;i++){
            copy[i][y] = -1;
        }
        return copy;
    }

    public static int check(int[][] copy, int x, int y, int team){
        int count = 0;
        copy = setMinus(copy,x, y);

        for(int i=0;i<copy.length;i++){
            for(int j=0;j<copy.length;j++){

                if(team<=0){
                    count++;
                    break;
                }
                else{
                    if(copy[i][j] == 1){
                        team--;
                        System.out.println("pairs with: " + i+","+j);
                        setMinus(copy, i, j);
                    }
                }

            }
        }
        return count;
    }


}
