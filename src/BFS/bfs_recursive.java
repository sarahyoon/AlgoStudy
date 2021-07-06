package BFS;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_recursive {

    public static boolean visited[];
    public static LinkedList[] adjList;
    public static int v;

    public static void main(String[] args){
        int n = 5;
        v = 3;

        visited= new boolean[n + 1];
        adjList = new LinkedList[n + 1];

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
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        bfs(queue);
    }

    public static void bfs (Queue<Integer> queue){

        if(queue.isEmpty()){
            return;
        }

        int val =  queue.poll();
        System.out.print(val + " ");

        Iterator<Integer> iter = adjList[val].listIterator();
        while(iter.hasNext()) {
            int w = iter.next();
            if(!visited[w]) {
                visited[w] = true;
                queue.add(w);
            }
        }

        bfs(queue);

    }
}
