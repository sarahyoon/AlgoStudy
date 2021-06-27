package CombinatorialSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardCover2 {

    static int blockSize;
    static int emptyCnt;
    static int best;
    static int H, W;
    static int[][] board;
    static List<List<int[]>> rotations;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            H = in.nextInt();
            W = in.nextInt();
            int R = in.nextInt();
            int C = in.nextInt();

            board = new int[H][W];
            int[][] block = new int[R][C];
            emptyCnt=0;
            blockSize=0;


            for(int j=0; j<H; j++) {
                String line;
                line = in.next();
                for(int k=0; k < W; k++) {
                    if (line.charAt(k) == '#') {
                        board[j][k] = 1;
                    } else {
                        board[j][k] = 0;
                        emptyCnt++;
                    }
                }
            }

            for(int j=0; j<R; j++) {
                String line;
                line = in.next();
                for(int k=0; k < C; k++) {
                    if (line.charAt(k) == '#') {
                        block[j][k] = 1;
                        blockSize++;
                    }else {
                        block[j][k] = 0;
                    }
                }
            }
            best=0;
            generateRotations(block);
            search(0);
            System.out.println(best);
        }
        in.close();
    }

    static int[][] rotate(int[][] block) {
        int row = block.length;
        int col = block[0].length;
        int[][] ret = new int[col][row];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                ret[j][row-i-1] = block[i][j];
            }
        }
        return ret;
    }

    static void generateRotations(int[][] block) {

        rotations = new ArrayList<>();
        for(int i=0; i<4; i++) {
            List<int[]> rotation = new ArrayList<>();
            int originX = -1;
            int originY = -1;
            for(int j=0; j<block.length; j++) {
                for(int k=0; k<block[0].length; k++){
                    if(block[j][k] == 1) {
                        if(originY == -1) {
                            originY = j;
                            originX = k;
                        }
                        rotation.add(new int[] {j - originY, k - originX});

                    }
                }
            }

            boolean dup = true;
            for(List<int[]> check_list : rotations) {
                dup = true;
                for (int j = 0; j < check_list.size(); j++) {
                    dup &= (check_list.get(j)[0] == rotation.get(j)[0]) && (check_list.get(j)[1] == rotation.get(j)[1]);
                }
                if (dup) {
                    break;
                }
            }
            if (!dup || rotations.isEmpty()) {
                rotations.add(rotation);
            }

            block = rotate(block);

        }
    }

    static void search(int placed) {

        if(placed + (emptyCnt / blockSize) <= best) return; //가지치기

        int x = -1, y = -1;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 0) {
                    x = j;
                    y = i;
                    break;
                }
            }
            if(y != -1) break;
        }

        if(y == -1) {
            best = Math.max(best, placed);
            return;
        }

        for(int i=0; i<rotations.size(); i++) {
            if(set(rotations.get(i), x, y, 1)) {
                emptyCnt -=blockSize;
                search(placed + 1);
                emptyCnt +=blockSize;
            }
            set(rotations.get(i), x, y, -1);
        }

        board[y][x] = 1;
        emptyCnt -= 1;
        search(placed);
        emptyCnt += 1;
        board[y][x] = 0;
    }

    static boolean set(List<int[]> block, int x, int y, int delta) {

        boolean ok = true;

        for(int i=0; i <block.size(); i++) {

            int nx = x + block.get(i)[1];
            int ny = y + block.get(i)[0];

            if(ny < 0 || ny >= H || nx < 0 || nx >= W) {
                ok = false;
            }
            else{
                board[ny][nx] += delta;
                if(board[ny][nx] > 1)
                    ok = false;
            }

        }

        return ok;
    }

}
