package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boggle {

    static final int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
    static final int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

    static int dp[][][];
    static Boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){

            String [][] board = new String[5][5];

            for(int h=0;h<5;h++){
                String lines = br.readLine();
                for(int w=0;w<5;w++){
                    board[h][w] = String.valueOf(lines.charAt(w));
                }
            }
            int numOfWords = Integer.parseInt(br.readLine());

            String [] words = new String[numOfWords];
            for(int n=0;n<numOfWords;n++){
                words[n] = br.readLine();
            }

            for(int c = 0;c<numOfWords;c++) {
                boolean isWord = false;

//                dp = new int[5][5][10];
//                for(int[][] a: dp){
//                    for(int[] b: a){
//                        Arrays.fill(b, 0);
//                    }
//                }

                visited = new Boolean[5][5];
                for(Boolean[] a: visited){
                    Arrays.fill(a, false);
                }
                for (int h = 0; h < 5; h++) {
                    for (int w = 0; w < 5; w++) {
                            if (hasword(h, w, board, words[c], 0, visited)){
                                isWord = true;
                                break;
                            }
                    }
                }
                if (isWord){
                    System.out.println(words[c] + " "+ "YES");
                }
                else{
                    System.out.println(words[c] + " "+ "NO");
                }
            }
        }

    }



    public static Boolean hasword(int y, int x, String[][] board, String word, int idx, Boolean[][] visited){


        if(x<0 || y<0 || x >= 5 || y >= 5) {
            return false;
        }


        if(visited[y][x] == false){
            return false;
        }
        visited[y][x] = true;

//        if(dp[y][x][idx] ==1){
//            return false;
//        }
//        dp[y][x][idx] = 1;

        if(!board[y][x].equals(String.valueOf(word.charAt(0)))){
            return false;
        }

        if(word.length() == 1){
            return true;
        }

        for(int i=0;i<8;i++){
            int next_y = y + dy[i];
            int next_x = x + dx[i];

            if(hasword(next_y, next_x, board, word.substring(1), idx+1, visited)){
                return true;
            }
        }

        return false;
    }

}
