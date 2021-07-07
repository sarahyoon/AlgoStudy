package DFS;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class dfs_recursive {

    public static void main(String[] args){
        int n = 5;
        int v = 3;

        boolean visited[] = new boolean[n + 1];

        LinkedList<Integer>[] adjList = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        adjList[5].add(4);
        adjList[5].add(2);
        adjList[1].add(2);
        adjList[3].add(4);
        adjList[3].add(1);
        adjList[4].add(5);
        adjList[4].add(3);
        adjList[2].add(5);
        adjList[2].add(1);
        adjList[1].add(3);

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        dfs(v, adjList, visited);
    }

    public static void dfs(int start, LinkedList<Integer>[] adjList, boolean[] visited){

            visited[start] = true;
            System.out.print(start + " ");

            Iterator<Integer> iter = adjList[start].listIterator();

            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    dfs(w, adjList, visited);
                }
            }
        }

}
