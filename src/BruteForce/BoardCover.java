package BruteForce;

import java.util.Scanner;

public class BoardCover {


    private static int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}}, //┌
            {{0, 0}, {0, 1}, {1, 1}}, // ┐
            {{0, 0}, {1, 0}, {1, 1}}, //└
            {{0, 0}, {1, 0}, {1, -1}} // ┘
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        String answer = "";

       for(int t=0;t<testCase;t++){

            int height = sc.nextInt();
            int width = sc.nextInt();
            int[][] board = new int[height][width];
            int white = 0;

            sc.nextLine();

            for(int i=0;i<height;i++){
                String tmp = sc.nextLine();
                for(int j = 0;j<width;j++){
                    if(tmp.charAt(j) == '#'){
                        board[i][j] = 1;
                    }else{
                        board[i][j] = 0;
                        white++;
                    }
                }
            }

            if(white%3 !=0){
                answer += 0 + "\n";
            }
            else{
                answer += cover(board) + "\n";
            }
        }
        System.out.println(answer);
    }


    private static boolean set(int[][] board, int y, int x, int type, int stack) {

        boolean ok = true;

        for (int i = 0; i < 3; i++) {
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok = false;

            } else if ((board[ny][nx] += stack) > 1) {
                ok = false;
            }
        }
        return ok;
    }

    private static int cover(int[][] board) {

        int y = -1, x = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) {
                break;
            }
        }

        if (y == -1) {
            return 1;
        }

        int result = 0;

        for (int type = 0; type < 4; type++) {
            if (set(board, y, x, type, 1)) {
                result += cover(board);
            }
            set(board, y, x, type, -1);
        }
        return result;
    }
}