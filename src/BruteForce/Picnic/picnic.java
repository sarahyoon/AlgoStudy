package BruteForce.Picnic;

import java.util.Arrays;
import java.util.Scanner;

public class picnic {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        String friends = "";
        String answer = "";

        for(int i=0;i<testCase;i++){

            int num_of_std = scan.nextInt();
            int f_pair = scan.nextInt();

            scan.nextLine();
            friends = scan.nextLine();

            answer += solve(num_of_std, f_pair, friends) + "\n" ;
        }
        System.out.println(answer);
    }

    public static int solve(int num_of_std, int f_pair, String friends){

        int team = num_of_std/2;

        if(team == f_pair){
            return 1;
        }

        int arr[][] = setnewArray(friends, num_of_std);
        Boolean[][] visited = new Boolean[num_of_std+1][num_of_std+1];
        for(Boolean a[]: visited){
            Arrays.fill(a, false);
        }

        int answer = 0;

        for(int i=0;i<arr.length;i++){
            for(int j= 0;j<arr[0].length;j++){

                if(arr[i][j] == 1){
                    int[][] copy = setnewArray(friends, num_of_std);

                    copy[i][j] = -1;
                    answer+= check(copy,i, j, team-1, visited);

                }
            }
        }

        return answer;
    }

    public static int[][] setnewArray(String friends, int num_of_std){

        int[][] arr = new int[num_of_std+1][num_of_std+1];

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

    public static int check(int[][] copy, int x, int y, int team, Boolean[][] visited){
        int count = 0;
        int check = 0;
        copy = setMinus(copy,x, y);

        if(visited[x][y] == false){
            visited[x][y] = true;
            check ++;
        }

        for(int i=0;i<copy.length;i++){
            for(int j=0;j<copy.length;j++){

                if(team<=0 && check >0){
                    count++;
                    check =0;
                    break;
                }
                else{

                    if(copy[i][j] == 1){
                        if(visited[i][j] == false){
                            check++;
                            visited[i][j] = true;
                        }
                        team--;
                        setMinus(copy, i, j);
                    }
                }
            }
        }

        return count;
    }


}
