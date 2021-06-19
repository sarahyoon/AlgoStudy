package CombinatorialSearch;

import java.util.Scanner;

public class BoardCover2 {

    public static int T, H, W, R, C,N,block_cnt,Answer;
    public static int[][] check = new int[10][10];
    public static char[][] map = new char[11][11];
    public static char[][][] block = new char[4][11][11];


    public static void setting() {
        N = 2;
        block_cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (block[0][i][j] != block[2][i][j]) N = 4;
                if (block[0][i][j] == '#') ++block_cnt;
            }
        }

        for (int i = H-1; i >= 0; i--) {
            for (int j = W-1; j >= 0; j--) {
                if (i == H-1 && j == W-1) {
                    check[i][j] = (map[i][j] == '.') ? 1 : 0;
                }
                else if (j == W-1) {
                    check[i][j] = check[i + 1][0] + ((map[i][j] == '.') ? 1 : 0);
                }
                else {
                    check[i][j] = check[i][j + 1] + ((map[i][j] == '.') ? 1 : 0);
                }
            }
        }

    }

    public static void rotate(int src, int des, int r, int c) {
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                block[des][j][r - i - 1] = block[src][i][j];
    }


    public static void backtracking(int x, int y, int s) {
        if (y == W) { backtracking(x + 1, 0, s); return; }
        if (x == H - 1 && y == W - 1) {
            Answer = s;
            return;
        }
        if (s + check[x][y] / block_cnt <= Answer) return;
        for (int n = 0; n < N; n++) {
            int r, c;
            if (n % 2 == 1) { r = C; c = R; }
            else { r = R; c = C; }
            if (x + r > H || y + c > W) continue;

            boolean flag = true;

            for (int i = 0; i < r && flag; i++) {
                for (int j = 0; j < c; j++) {
                    if (block[n][i][j] == '#' && map[x + i][y + j] == '#') {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) continue;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (block[n][i][j] == '#') {
                        map[x + i][y + j] = '#';
                    }
                }
            }
            backtracking(x, y + 1, s + 1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (block[n][i][j] == '#') {
                        map[x + i][y + j] = '.';
                    }
                }
            }
        }
        backtracking(x, y + 1, s);
    }



    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int test_case;
        int c = sc.nextInt();
        String str = new String();

        for(test_case = 1 ;test_case <=c ;test_case ++)
        {
            H = sc.nextInt();
            W = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();

            for(int i = 0;i<H;i++)
            {
                str= sc.nextLine();
                for(int j=0;j<W;j++)
                {
                    map[i][j]=str.charAt(j);
                }
            }

            for(int i = 0;i<R;i++)
            {
                str= sc.nextLine();
                for(int j=0;j<C;j++)
                {
                    block[0][i][j]=str.charAt(j);
                }
            }

            rotate(0, 1, R, C);
            rotate(1, 2, C, R);
            rotate(2, 3, R, C);
            setting();
            Answer = 0;
            backtracking(0,0,0);
            System.out.println(Answer);
        }

    }
}
