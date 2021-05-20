package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class TP1 {

    public static double result;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            result = Double.MAX_VALUE;
            int num_of_city = scan.nextInt();

            Double [][] paths = new Double[num_of_city][num_of_city];
            Boolean[] visited = new Boolean[num_of_city];

            Arrays.fill(visited, false);

            for(int j=0;j<num_of_city;j++){

                for(int k=0;k<num_of_city;k++){
                    paths[j][k] = scan.nextDouble();
                }
            }

            for(int t = 0;t<num_of_city;t++){
               search(t, 0, 0.0, paths, visited);
            }
            System.out.println(result);
        }
    }

    public static void search(int city, int count, double cost, Double[][] paths, Boolean[] visited){

        if(count == paths.length-1){
            result = Math.min(result, cost);
            return ;
        }

        visited[city] = true;

        for(int i=0;i<paths.length;i++){
            if(!visited[i]){
                search(i, count+1, cost+paths[city][i], paths, visited);
            }
        }
        visited[city] = false;

    }
}
