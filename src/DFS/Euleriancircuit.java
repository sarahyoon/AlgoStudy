package DFS;

import java.util.Scanner;
import java.util.Stack;

public class Euleriancircuit {

    static Scanner scn = new Scanner(System.in);
    static int[][] GP_Array;
    static Stack<Integer> stack = new Stack<Integer>();

    static void findRandomCircuit(int here) {
        for (int there = 1; there < GP_Array[here].length; there++) {
            while (GP_Array[here][there] > 0) {
                GP_Array[here][there]--;
                GP_Array[there][here]--;
                findRandomCircuit(there);
            }
        } // for()
        stack.push(here);
    }

    static boolean check() {
        for (int i = 1; i < GP_Array.length; i++) {
            int sum = 0;
            for (int j = 1; j < GP_Array[i].length; j++) {
                sum += GP_Array[i][j];
            }
            if (sum % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int v_Cnt;

        v_Cnt = scn.nextInt();

        GP_Array = new int[v_Cnt + 1][v_Cnt + 1];

        for (int i = 1; i < GP_Array.length; i++) {
            for (int j = 1; j < GP_Array[i].length; j++) {
                int input = scn.nextInt();
                GP_Array[i][j] = input;
                GP_Array[j][i] = input;
            }
        }
        if (!check())
            System.out.print("-1");
        else {
            findRandomCircuit(1);
            while (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
    }
}
