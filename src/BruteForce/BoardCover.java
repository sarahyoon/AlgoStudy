package BruteForce;

import java.util.Scanner;

public class BoardCover {

    public static int coverType[][][] = {
            { {0,0}, {1,0}, {0,1} }, { {0,0}, {0,1}, {1,1} }, { {0,0}, {1,0}, {1,1} }, { {0,0}, {1,0}, {1,-1} } };


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        String answer = "";

        for(int i=0;i<testCase;i++){

            int h = scan.nextInt();
            int w = scan.nextInt();

            int white = 0;
            int[][] board = new int[h][w];

            for(int k=0;k<h;k++){
                String line = scan.next();

                for(int j = 0;j<w;j++){
                    if(line.charAt(j) == '#'){
                        board[k][j] = 1;
                    }
                    else{
                        board[k][j] = 0;
                        white++;
                    }
                }
            }

            if(white%3 != 0){
                answer += 0 + "\n";
            }
            else{
                answer += solve(board) + "\n" ;
            }
        }
        System.out.println(answer);
    }

    public static int solve(int[][] board){
        int count = 0;
        int x = -1;
        int y = -1;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(y != -1){
                break;
            }
        }

        if(y == -1){
            return 1;
        }

        for(int i = 0;i<4;i++){
            if(setBoard(x, y, i, 1, board)){
                count+= solve(board);
            }

            setBoard(x, y, i, -1, board);
        }
        return count;
    }

    public static boolean setBoard(int x, int y, int type, int offset, int board[][]){
        boolean check = true;

        for(int i=0;i<3;i++){

            int dy = y + coverType[type][i][0];
            int dx = x + coverType[type][i][1];

            if(dx<0 ||dx >=board.length|| dy <0 || dy>=board[0].length ){
                check = false;
            }
            else if((board[dx][dy]+=offset)>1){
                check = false;
            }
        }
        return check;
    }
}
