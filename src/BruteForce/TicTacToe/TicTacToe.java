package BruteForce.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

        static char[][] board = new char[3][3];
        static int[] dp = new int[19683];

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int testCase = scanner.nextInt();

            for (int i = 0; i < testCase; i++) {
                Arrays.fill(dp, -2);

                int countX = 0;
                int countY = 0;
                char turn;
                for (int m = 0; m < 3; m++) {
                    String temp = scanner.next();
                    for (int n = 0; n < 3; n++) {
                        board[m][n] = temp.charAt(n);
                        if (board[m][n] == 'x')
                            countX++;

                        if(board[m][n] == 'o')
                            countY++;
                    }
                }
                if (countX == countY)
                    turn = 'x';
                else
                    turn = 'o';

                if (canWin(turn) == 1)
                    System.out.println(turn);
                else if (canWin(turn) == -1)
                    System.out.println(alter(turn));
                else
                    System.out.println("TIE");
            }
        }

        private static int bijection() {
            int ret = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    ret *= 3;
                    if (board[x][y] == 'x')
                        ret += 1;

                    if (board[x][y] == 'o')
                        ret += 2;
                }
            }

            return ret;
        }

        private static boolean isFinished(char turn) {
//        col
            for (int col = 0; col < 3; col++) {
                if (board[0][col] == turn && board[1][col] == turn && board[2][col] == turn)
                    return true;
            }
//        row
            for (int row = 0; row < 3; row++) {
                if (board[row][0] == turn && board[row][1] == turn && board[row][2] == turn)
                    return true;
            }
//        diagonal
            if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn)
                return true;
            if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn)
                return true;

            return false;
        }

        private static int canWin(char turn) {
            int bijec = bijection();
            int minValue = 2;
            if (dp[bijec] != -2)
                return dp[bijec];

            if (isFinished(alter(turn))) return -1;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y] == '.') {
                        board[x][y] = turn;
                        minValue = Math.min(minValue, canWin(alter(turn)));
                        board[x][y] = '.';
                    }
                }
            }

            if (minValue == 2 || minValue == 0)
                return dp[bijec] = 0;

            return dp[bijec] = -minValue;
        }

        private static char alter(char turn) {
            if (turn == 'o')
                return 'x';
            return 'o';
        }
}
