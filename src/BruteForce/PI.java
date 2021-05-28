package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class PI {

    static int INF = 987654321;
    static int[] numbers;
    static int[] result;
    static int[][] levels;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int t=0; t<testCase; t++){

            String str = sc.next();
            numbers = new int[str.length()];
            result = new int[str.length()];
            levels = new int[str.length()][3];

            for(int i=0; i<str.length(); i++) {
                numbers[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            System.out.println(totalMinLevel(0));
        }
    }


    public static int totalMinLevel(int start){
        if(result[start] != 0)
            return result[start];

        result[start] = INF;

        for(int length = 3; length <= 5; length++){
            if(start + length < numbers.length)
                result[start] = Math.min(result[start], totalMinLevel(start + length) + currentLevel(start, length));
            else if(start + length == numbers.length)
                result[start] = Math.min(result[start], currentLevel(start, length));
        }
        return result[start];
    }

    public static int currentLevel(int start, int length){
        if(levels[start][length - 3] != 0)
            return levels[start][length - 3];

        levels[start][length - 3] = 10;

        if(isLevelOne(start, start + length))
            levels[start][length - 3] = 1;
        else if(isLevelTwo(start, start + length)){
            levels[start][length - 3] = 2;
        }else if(isLevelFour(start, start + length)) {
            levels[start][length - 3] = 4;
        }else if(isLevelFive(start, start + length)){
            levels[start][length - 3] = 5;
        }
        return levels[start][length - 3];
    }

    public static boolean isLevelOne(int start, int end){
        int first = numbers[start];

        for(int i=start + 1; i<end; i++){
            if(numbers[i] != first)
                return false;
        }
        return true;
    }

    public static boolean isLevelTwo(int start, int end){
        int diff = numbers[start + 1] - numbers[start];

        if(diff == 1 || diff == -1)
            return isSequence(start, end, diff);
        return false;
    }

    public static boolean isLevelFour(int start, int end) {
        int[] repeatNumbers = {numbers[start], numbers[start + 1]};

        int count = 0;

        for(int i=start + 2; i<end; i++){
            if(numbers[i] != repeatNumbers[count])
                return false;

            count^=1;
        }
        return true;
    }

    public static boolean isLevelFive(int start, int end){
        int diff = numbers[start + 1] - numbers[start];
        return isSequence(start, end, diff);
    }

    public static boolean isSequence(int start, int end, int diff) {
        int prev = numbers[start + 1];

        for(int i=start + 2; i<end; i++){
            if(!(numbers[i] - prev == diff))
                return false;

            prev = numbers[i];
        }

        return true;
    }



}
