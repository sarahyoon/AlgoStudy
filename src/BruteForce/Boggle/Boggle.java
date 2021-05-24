package BruteForce.Boggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boggle {

    static final int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
    static final int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

    static int dp[][][];

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

                dp = new int[5][5][10];
                for(int[][] a: dp){
                    for(int[] b: a){
                        Arrays.fill(b, 0);
                    }
                }

                for (int h = 0; h < 5; h++) {
                    for (int w = 0; w < 5; w++) {
                            if (hasword(h, w, board, words[c], 0)){
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



    //y, x: board 좌표
    //board
    //word: 주어진 문자열
    //idx: 주어진 문자열의 위치
    // dp[y][x][idx]: 이미 찾은 문자열 표기
    public static Boolean hasword(int y, int x, String[][] board, String word, int idx) {

        //board 범위 밖인 경우,
        if(x<0 || y<0 || x>=5 || y>=5){
            return false;
        }



        //이미 찾은 문자면,
        if(dp[y][x][idx] == 1){
            return false;
        }


        //찾으려는 문자가 현재 좌표위치에서 없으면,
        if(!(board[y][x].equals(word.charAt(0)+""))){
            return false;
        }

        dp[y][x][idx] = 1;

        if(word.length() == 1){
            return true;
        }

        //상하좌우 대각선 찾기
        for(int i=0;i<8;i++){
            int next_x = x+dx[i];
            int next_y= y+dy[i];

            if(hasword(next_y, next_x, board, word.substring(1), idx+1)){
                return true;
            }
        }
        return false;
    }


}
