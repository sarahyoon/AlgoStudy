package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class wordchain {

    static Stack<String>[][] graph;
    static int[][] adj;
    static int[] indegree, outdegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++) {

            int nums = Integer.parseInt(br.readLine());
            String[] arr = new String[nums];

            for (int j = 0; j < nums; j++) {
                arr[j] = br.readLine().trim();
            }
            System.out.println(solve(arr));

        }
    }

    static String solve(String[] arr) {

        makeGraph(arr);

        if (!checkEuler()){
            return "IMPOSSIBLE";
        }

        ArrayList<Integer> circuit = getEulerTrailOrCircuit();
        if (circuit.size() != arr.length + 1){
            return "IMPOSSIBLE";
        }

        Collections.reverse(circuit);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < circuit.size(); i++) {
            int a = circuit.get(i - 1), b = circuit.get(i);
            sb.append(graph[a][b].pop() + " ");
        }
        return sb.toString();
    }

    public static void makeGraph(String[] words){

        graph = new Stack[26][26];
        adj = new int[26][26];
        indegree = new int[26];
        outdegree = new int[26];

        for(int i=0;i<words.length;i++){

            int first = words[i].charAt(0) - 'a';
            int last = words[i].charAt(words[i].length() -1) - 'a';

            if(graph[first][last] == null){
                graph[first][last] = new Stack<String>();
            }
            graph[first][last].push(words[i]);
            adj[first][last]++;
            outdegree[first]++;
            indegree[last]++;
        }
    }

    public static boolean checkEuler(){

        int pl = 0;
        int mi = 0;

        for(int i=0;i<26;i++){
            int delta = outdegree[i] - indegree[i];
            if(delta < -1 || 1 < delta){
                return false;
            }
            if(delta == 1){
                pl ++;
            }
            if(delta == -1){
                mi ++;
            }
        }

        return (pl==1 && mi ==1) || (pl==0 && mi == 0);
    }

    static ArrayList<Integer> getEulerTrailOrCircuit(){
        ArrayList<Integer> circuit = new ArrayList<Integer>();
        // 오일러 트레일을 찾아본다 -> 시작점이 존재하는경우
        for (int i = 0; i < 26; i++)
            if (outdegree[i] == indegree[i] + 1) {
                getEulerCircuit(i, circuit);
                return circuit;
            }
        // 트레일이 존재하지 않을 때 간선에 인접한
        // 아무 정점에서 시작하는 서킷을 찾는다.
        for (int i = 0; i < 26; i++)
            if (outdegree[i] != 0) {
                getEulerCircuit(i, circuit);
                return circuit;
            }
        // 모두 실패한 경우
        return null;
    }

    static void getEulerCircuit(int cur, ArrayList<Integer> circuit){
        for (int i = 0; i < 26; i++)
            while (adj[cur][i] > 0) {
                adj[cur][i]--;
                getEulerCircuit(i, circuit);
            }
        circuit.add(cur);
    }
}
