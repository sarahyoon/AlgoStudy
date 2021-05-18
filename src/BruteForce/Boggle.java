package BruteForce;

import java.util.Scanner;

public class Boggle {

    static final int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
    static final int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

    static String[] answer;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<testCase;i++){

            String [][] board = new String[5][5];

            for(int h=0;h<5;h++){
                String lines = scan.nextLine();
                for(int w=0;w<5;w++){
                    board[h][w] = String.valueOf(lines.charAt(w));
                }
            }

            int numOfWords = scan.nextInt();

            String [] words = new String[numOfWords];
            for(int n=0;n<numOfWords;n++){
                words[n] = scan.next();
            }

            answer = new String[numOfWords];

            for(int c = 0;c<numOfWords;c++) {
                boolean isWord = false;

                for (int h = 0; h < 5; h++) {
                    for (int w = 0; w < 5; w++) {
                        if (hasword(h, w, board, words[c])){
                            System.out.println(words[c]);
                            isWord = true;
                            break;
                        }
                    }
                    if(isWord){
                        break;
                    }
                }
                if (isWord){
                    answer[c] = words[c] + " "+ "YES";
                }
                else{
                    answer[c] = words[c] + " "+ "NO";
                }
            }
        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }



    public static Boolean hasword(int y, int x, String[][] board, String word){

        if(x<0 || y<0 || x >= 5 || y >= 5){
            return false;
        }

        if(!board[y][x].equals(String.valueOf(word.charAt(0)))){
            return false;
        }

        if(word.length() == 1){
            return true;
        }

        for(int i=0;i<8;i++){
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            if(hasword(next_y, next_x, board, word.substring(1))){
                return true;
            }
        }
        return false;
    }

}
