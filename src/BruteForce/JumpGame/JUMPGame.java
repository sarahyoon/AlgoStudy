package BruteForce.JumpGame;

import java.io.*;
import java.util.Arrays;

public class JUMPGame {

    static int[][] board;
    static int n;
    static int[][] cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ans = "";
        int testCase = Integer.parseInt(br.readLine().trim());

        for(int t=0;t<testCase;t++){

            n = Integer.parseInt(br.readLine().trim());
            board = new int[n][n];
            cache = new int[n][n];
            for(int[] a : cache){
                Arrays.fill(a, -1);
            }

            for(int x = 0;x<n;x++){
                String lines = br.readLine();
                for(int y=0;y<n;y++){
                    board[x][y] = Integer.parseInt(lines.split(" ")[y]);
                }
            }

            ans += (jump(0, 0) != 0 ? "YES" : "NO") + "\n";
        }
        bw.write(ans);
        bw.flush();
        bw.close();

    }

    static int jump(int x, int y){

        if(x>=n || y>=n){
            return 0;
        }
        if(x == n-1 && y == n-1){
            return 1;
        }

        if(cache[x][y] != -1){
            return cache[x][y];
        }

        int jumpLength = board[x][y];

        return cache[x][y] = jump(x+jumpLength, y) | jump(x, y+jumpLength);

    }
}
