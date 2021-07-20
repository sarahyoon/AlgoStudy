package DFS;

import java.io.*;
import java.util.*;

//public class Main {
public class Dictionary {

    static int C, N;
    static boolean isCycle;
    static boolean[] visited, finished;
    static Stack<Character> stack;
    static int[][] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for (int t = 1; t <= C; t++) {

            N = Integer.parseInt(br.readLine());

            String[] strArr = new String[N];
            adj = new int[26][26];
            visited = new boolean[26];
            finished = new boolean[26];

            stack = new Stack<>();
            isCycle = false;

            for (int i = 0; i < N; i++)
            {
                strArr[i] = br.readLine();
            }

            makeAdjacent(adj, strArr);

            for (int i = 0; i < 26; i++) {
                if (!finished[i]){
                    dfs(i);
                }
            }

            if (isCycle){
                System.out.print("INVALID HYPOTHESIS");
            }
            else{
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
            }
            System.out.println();
        }
    }

    public static void dfs(int v) {

        visited[v] = true;
        for (int i = 0; i < 26; i++) {

            if (adj[v][i] == 1) {

                if (!visited[i]){
                    dfs(i);
                }

                else if (!finished[i]){
                    isCycle = true;
                }
            }
        }
        finished[v] = true;
        stack.push((char) (v + 'a'));
    }

    public static void makeAdjacent(int[][] adj, String[] strArr) {

        int length = strArr.length;

        for (int i = 0; i < length - 1; i++) {

            int wordLen = Math.min(strArr[i].length(), strArr[i + 1].length());

            for (int j = 0; j < wordLen; j++) {

                if (strArr[i].charAt(j) != strArr[i + 1].charAt(j)) {
                    adj[strArr[i].charAt(j) - 'a'][strArr[i + 1].charAt(j) - 'a'] = 1;
                    break;
                }
            }
        }

    }

}
