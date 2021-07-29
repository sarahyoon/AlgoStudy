package SpanningTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int a;
    int b;
    double c;

    public Edge(int a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}


public class LAN {

    public static int[] par;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            par = new int[N + 1];
            for (int i = 0; i < N; i++) {
                par[i] = i;
            }

            int[] x = new int[N + 1];
            int[] y = new int[N + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            PriorityQueue<Edge> que = new PriorityQueue<>(new Comparator<Edge>() {
                public int compare(Edge o1, Edge o2) {
                    return Double.compare(o1.c, o2.c);
                }
            });

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    que.add(new Edge(i, j, Math.sqrt(Math.abs(x[j] - x[i]) * Math.abs(x[j] - x[i]) + Math.abs(y[j] - y[i]) * Math.abs(y[j] - y[i]))));
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                que.add(new Edge(a, b, 0));
            }

            int cnt = 0;
            double ans = 0.0;

            while (!que.isEmpty()) {
                if (cnt == N - 1) {
                    break;
                }
                Edge e = que.poll();
                int a = find(e.a);
                int b = find(e.b);
                if (a == b) {
                    continue;
                }
                par[b] = a;
                ans += e.c;
                cnt++;
            }
            System.out.printf("%.10f\n", ans);
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int n) {
        if (par[n] == n) {
            return n;
        }
        return par[n] = find(par[n]);
    }
}


