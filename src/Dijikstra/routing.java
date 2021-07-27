package Dijikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class routing {

    static int N; // 컴퓨터의 수 N (<= 10000)
    static int M; // 회선의 수 M (<= 20000)
    static final double INF = Double.MAX_VALUE;
    static ArrayList<Node> edge[];
    static double dist[];
    static boolean check[];

    public static class Node implements Comparable<Node>{
        int e;
        double w;
        public Node(int e, double w) {
            super();
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Node right) {
            if (w > right.w) {
                return 1;
            } else if (w == right.w) {
                return 0;
            } else {
                return -1;
            }
        }

    }

    public static void search(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 1;

        pq.add(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (check[now.e] == true ) {
                continue;
            }
            check[now.e] = true;

            for (int i = 0; i < edge[now.e].size(); i++) {
                Node next = edge[now.e].get(i);

                //최단거리 갱신하기
                if (dist[next.e]> dist[now.e] * next.w ) {
                    dist[next.e] = dist[now.e] * next.w ;
                    pq.add(new Node ( next.e, dist[next.e]));
                }

            }

        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  //정점의 갯수
            M = Integer.parseInt(st.nextToken());  //간선의 갯수

            dist = new double[N];
            check = new boolean[N];

            Arrays.fill(dist, INF);

            edge = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                edge[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int start, end;
                double w;

                st = new StringTokenizer(br.readLine().trim());

                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                w = Double.parseDouble(st.nextToken());

                edge[start].add(new Node(end, w));
                edge[end].add(new Node(start, w));

            }

            search(0);
            System.out.printf("%.10f", dist[N-1]);
            System.out.println();
        }

    }

}